package com.mahendracandi.springcachingexample.service;

import com.mahendracandi.springcachingexample.model.Product;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    private final static Logger LOG = Logger.getLogger(ProductServiceImpl.class);

    @Override
    @Cacheable(value = "products", cacheManager = "cacheManager")
    public Product getByName(String name) {
        slowLookUpOperation();
        return new Product(name, 100);
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void refreshAllProducts(){

    }

    private void slowLookUpOperation(){
        try{
            long time = 5000;
            Thread.sleep(time);
        }catch (InterruptedException e){
            LOG.error("THIS ERROR: ", e);
            throw new IllegalStateException(e);
        }
    }
}
