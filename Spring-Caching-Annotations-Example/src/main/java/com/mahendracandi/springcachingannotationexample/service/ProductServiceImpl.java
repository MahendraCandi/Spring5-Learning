package com.mahendracandi.springcachingannotationexample.service;

import com.mahendracandi.springcachingannotationexample.model.Product;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final static Logger log = Logger.getLogger(ProductServiceImpl.class);
    private static List<Product> products;

    static {
        products = getDummyProducts();
    }

    @Override
    @Cacheable(value = "products", key = "#name", condition = "#name!='BUBUR AYAM'", unless = "#result==null")
    public Product getByName(String name) {
        log.info("-----------------------MASUK KE getByName() METHOD------------------------");
        for (Product p : products) {
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void refreshAllProducts() {}

    @Override
    @CachePut(value = "products", key = "#product.name", unless = "#result==null")
    public Product updateProduct(Product product) {
        log.info("-----------------------MASUK KE updateProduct() METHOD------------------------");
        for (Product p : products){
            if(p.getName().equalsIgnoreCase(product.getName())){
                p.setPrice(product.getPrice());
                return p;
            }
        }
        return null;
    }

    private static List<Product> getDummyProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("NASI PADANG", 12000));
        products.add(new Product("MIE GORENG", 13000));
        products.add(new Product("BUBUR AYAM", 10000));
        return products;
    }
}
