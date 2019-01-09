package com.mahendracandi.springcachingexample.service;

import com.mahendracandi.springcachingexample.model.Product;

public interface ProductService {
    Product getByName(String name);
    void refreshAllProducts();
}
