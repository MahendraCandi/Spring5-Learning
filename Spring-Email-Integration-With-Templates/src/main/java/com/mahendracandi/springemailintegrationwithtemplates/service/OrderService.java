package com.mahendracandi.springemailintegrationwithtemplates.service;

import com.mahendracandi.springemailintegrationwithtemplates.model.ProductOrder;

public interface OrderService {
    void sendOrderConfirmation(ProductOrder productOrder);
}
