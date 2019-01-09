package com.mahendracandi.springemailintegration.services;

import com.mahendracandi.springemailintegration.model.ProductOrder;

public interface OrderService {
    void sendOrderConfirmation(ProductOrder productOrder);
}
