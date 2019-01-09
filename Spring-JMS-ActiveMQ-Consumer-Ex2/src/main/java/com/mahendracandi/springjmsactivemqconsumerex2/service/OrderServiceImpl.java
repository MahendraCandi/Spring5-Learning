package com.mahendracandi.springjmsactivemqconsumerex2.service;

import com.mahendracandi.springjmsactivemqconsumerex2.messaging.MessageSender;
import com.mahendracandi.springjmsactivemqconsumerex2.model.InventoryResponse;
import com.mahendracandi.springjmsactivemqconsumerex2.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    private final static Logger LOG = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Override
    public void processOrder(Product product) {
        InventoryResponse inventoryResponse = prepareResponseProduct(product);
        LOG.info("INVENTORY : MENGIRIM KONFIRMASI ORDER " + inventoryResponse);
        messageSender.sendMessage(inventoryResponse);
    }

    private InventoryResponse prepareResponseProduct(Product product){
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setProductId(product.getProductId());
        inventoryResponse.setReturnCode(200);
        inventoryResponse.setComment("PROSES ORDER BERHASIL");
        return inventoryResponse;
    }
}
