package com.mahendracandi.springcachingannotationexample.service;

import com.mahendracandi.springcachingannotationexample.model.Product;

public interface ProductService {
    Product getByName(String name);
    void refreshAllProducts();
    Product updateProduct(Product product);
}
