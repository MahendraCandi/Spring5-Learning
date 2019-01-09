package com.mahendracandi.springemailintegrationwithattachment.service;

import com.mahendracandi.springemailintegrationwithattachment.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    MailService mailService;

    @Override
    public void sendOrderConfirmation(ProductOrder productOrder) {
        mailService.sendEmail(productOrder);
    }
}
