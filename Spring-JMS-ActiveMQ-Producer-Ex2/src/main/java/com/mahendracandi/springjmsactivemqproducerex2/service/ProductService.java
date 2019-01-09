package com.mahendracandi.springjmsactivemqproducerex2.service;

import com.mahendracandi.springjmsactivemqproducerex2.model.Product;

public interface ProductService {
    void sendProduct(Product product);
    void getEnvirontment();
}
