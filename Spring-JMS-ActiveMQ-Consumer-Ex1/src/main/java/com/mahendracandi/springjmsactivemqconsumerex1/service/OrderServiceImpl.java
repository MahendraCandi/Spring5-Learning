package com.mahendracandi.springjmsactivemqconsumerex1.service;

import com.mahendracandi.springjmsactivemqconsumerex1.messaging.MessageSender;
import com.mahendracandi.springjmsactivemqconsumerex1.model.InventoryResponse;
import com.mahendracandi.springjmsactivemqconsumerex1.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    Logger log = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void processOrder(Product product) {
        InventoryResponse response = prepareResponse(product);
        log.info("Inventory : SENDING order confirmastion " + response);
        messageSender.sendMessage(response);
    }

    private InventoryResponse prepareResponse(Product product){
        InventoryResponse response = new InventoryResponse();
        response.setProductId(product.getProductId());
        response.setReturnCode(200);
        response.setComment("ORDER PROSES BERHASIL");
        return response;
    }
}
