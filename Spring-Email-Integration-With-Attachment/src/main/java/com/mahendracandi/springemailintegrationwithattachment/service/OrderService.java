package com.mahendracandi.springemailintegrationwithattachment.service;

import com.mahendracandi.springemailintegrationwithattachment.model.ProductOrder;

public interface OrderService {
    void sendOrderConfirmation(ProductOrder productOrder);
}
