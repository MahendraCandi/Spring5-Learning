package com.mahendracandi.springemailintegrationwithtemplates.service;

import com.mahendracandi.springemailintegrationwithtemplates.model.ProductOrder;
import freemarker.template.Configuration;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service("mailService")
public class MailServiceImpl implements MailService {
    private final static Logger LOG = Logger.getLogger(MailServiceImpl.class);

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    VelocityEngine velocityEngine;

    @Autowired
    Configuration freemarkerConfiguration;

    @Override
    public void sendMail(Object object) {
        ProductOrder order = (ProductOrder) object;
        MimeMessagePreparator preparator = getMessagePreparator(order);
        try{
            mailSender.send(preparator);
        }catch(MailException e){
            LOG.error("ERROR DISINI ", e);
        }
    }

    private MimeMessagePreparator getMessagePreparator(final ProductOrder order){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

                helper.setSubject("EMAIL WITH TEMPLATES");
                helper.setFrom("TES.EMAIL@TESTING.COM");
                helper.setTo(order.getCustomerInfo().getEmail());

                Map<String, Object> model = new HashMap<String, Object>();
                model.put("order", order);

                // just replace with velocity or freemarker
                String text = getVelocityTemplate(model);
                LOG.info("TEMPLATE CONTENT : " + text);

                // multipart mime message adalah mengirim html dan text dalam sebuah pesan email
                helper.setText(text, true);

                // kirim attachment
                helper.addAttachment("COKELAT-ENAK.jpg", new ClassPathResource("image/chocolatos.jpg"));
            }
        };
        return preparator;
    }

    private String getVelocityTemplate(Map<String, Object> model){
        String text = "";
        try{
            VelocityContext velocityContext = new VelocityContext();
            for (String key : model.keySet()) {
                velocityContext.internalPut(key, model.get(key));
            }
            StringWriter stringWriter = new StringWriter();
            velocityEngine.mergeTemplate("vtemplates/velocity_mailTemplate.vm", "UTF-8", velocityContext, stringWriter);
            text = stringWriter.toString();
        }catch (Exception e){
            LOG.error("ERROR KETIKA PROSES VELOCITY TEMPLATE ", e);
        }
        return text;
    }

    private String getFreeMarkerTemplate(Map<String, Object> model){
        StringBuilder builder = new StringBuilder();
        try{
            builder.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("fm_mailTemplate.txt"), model));
            return builder.toString();
        }catch(Exception e){
            LOG.error("ERROR KETIKA PROSES FREEMARKER TEMPLATE", e);
        }
        return "";
    }
}
