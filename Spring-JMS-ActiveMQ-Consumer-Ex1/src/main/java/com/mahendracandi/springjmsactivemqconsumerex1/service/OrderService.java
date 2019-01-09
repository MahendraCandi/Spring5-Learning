package com.mahendracandi.springjmsactivemqconsumerex1.service;

import com.mahendracandi.springjmsactivemqconsumerex1.model.Product;

public interface OrderService {
    public void processOrder(Product product);
}
