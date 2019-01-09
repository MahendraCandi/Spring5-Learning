package com.mahendracandi.springemailintegration.services;

import com.mahendracandi.springemailintegration.model.ProductOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

@Service("mailService")
public class MailServiceImpl implements MailService {
    private final static Logger LOG = Logger.getLogger(MailServiceImpl.class);

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Object object) {
        ProductOrder order = (ProductOrder) object;
        MimeMessagePreparator preparator = getMessagePreparator(order);

        try {
            mailSender.send(preparator);
            LOG.info("PESAN DIKIRIM...........");
        }catch (MailException e){
            LOG.error("ERROR DISINI: ", e);
        }
    }

    private MimeMessagePreparator getMessagePreparator(final ProductOrder order){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("Mail.SMTP.Tes");
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(order.getCustomerInfo().getEmail()));
                mimeMessage.setText("Dear " + order.getCustomerInfo().getName() + " sudah mamam blon..?. Your Id is " + order.getOrderId() + ". " + "Your Pesanan is " + order.getProductName());
                mimeMessage.setSubject("TESTING KIRIM EMAIL DARI APLIKASI");
            }
        };

//        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
//            mimeMessage.setFrom("Mail.SMTP.Tes");
//            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(order.getCustomerInfo().getEmail()));
//            mimeMessage.setText("Dear " + order.getCustomerInfo().getName() + " sudah mamam blon..?. Your Id is " + order.getOrderId() + ". " +
//                    "Your Pesanan is " + order.getProductName());
//            mimeMessage.setSubject("TESTING KIRIM EMAIL DARI APLIKASI");
//        };
        return preparator;
    }
}
