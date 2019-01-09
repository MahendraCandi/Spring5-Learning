package com.mahendracandi.springjmsactivemqconsumerex2.service;

import com.mahendracandi.springjmsactivemqconsumerex2.model.Product;

public interface OrderService {
    void processOrder(Product product);
}
