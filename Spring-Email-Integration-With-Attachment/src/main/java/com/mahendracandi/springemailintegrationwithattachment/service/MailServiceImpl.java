package com.mahendracandi.springemailintegrationwithattachment.service;

import com.mahendracandi.springemailintegrationwithattachment.model.ProductOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {
    private final static Logger LOG = Logger.getLogger(MailServiceImpl.class);

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Object object) {
        ProductOrder order = (ProductOrder) object;
        try {
            MimeMessagePreparator preparator = getContentWithAttachmentMessagePreparator(order);
            mailSender.send(preparator);
            LOG.info("EMAIL DENGAN ATTACHMENT TELAH DIKIRIM .....................");
            preparator = getContentAsInlineResourceMessagePreparator(order);
            mailSender.send(preparator);
            LOG.info("EMAIL DENGAN INLINE RESOURCE TELAH DIKIRIM ................");
        }catch (MailException e){
            LOG.error("ERROR DISINI: ", e);
        }
    }

    private MimeMessagePreparator getContentWithAttachmentMessagePreparator(final ProductOrder order){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setSubject("EMAIL WITH ATTACHMENT");
                helper.setFrom("TES.EMAIL@TESTING.COM");
                helper.setTo(order.getCustomerInfo().getEmail());
                StringBuilder builder = new StringBuilder()
                        .append("Dear " + order.getCustomerInfo().getName() + ",")
                        .append("\n\nTerimakasih telah order dengan nomor Id " + order.getOrderId() + ". ")
                        .append("Berikut ini adalah pesanan yang kamu order " + order.getProductName() + ". ")
                        .append("\n\nRegards\n")
                        .append("Shop-Test");
                helper.setText(builder.toString());

                // add image attachment
                helper.addAttachment("COKELAT-MANTAP.jpg", new ClassPathResource("image/chocolatos.jpg"));
            }
        };
        return preparator;
    }

    private MimeMessagePreparator getContentAsInlineResourceMessagePreparator(final ProductOrder order){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.setSubject("EMAIL WITH INLINE RESOURCES");
                helper.setFrom("TES.EMAIL@TESTING.COM");
                helper.setTo(order.getCustomerInfo().getEmail());
                StringBuilder builder = new StringBuilder()
                        .append("Dear " + order.getCustomerInfo().getName() + " dari " + order.getCustomerInfo().getAddress())
                        .append("\n\nTerimakasih telah order dengan nomor Id " + order.getOrderId() + ". ")
                        .append("Berikut ini adalah pesanan yang kamu order " + order.getProductName() + ". ")
                        .append("\n\nRegards\n")
                        .append("Shop-Test");
                //inject html di text
                helper.setText("<html><body><p>" + builder.toString() + "</p><img src='cid:image-logo'></body></html>",true);
                helper.addInline("image-logo", new ClassPathResource("image/chocolatos.jpg"));
            }
        };
        return preparator;
    }
}
