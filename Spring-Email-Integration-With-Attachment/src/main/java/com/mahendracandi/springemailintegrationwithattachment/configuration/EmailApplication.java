package com.mahendracandi.springemailintegrationwithattachment.configuration;

import com.mahendracandi.springemailintegrationwithattachment.model.CustomerInfo;
import com.mahendracandi.springemailintegrationwithattachment.model.ProductOrder;
import com.mahendracandi.springemailintegrationwithattachment.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmailApplication {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.sendOrderConfirmation(getProductOrder());
        context.close();
    }

    private static ProductOrder getProductOrder(){
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrderId("12345-qwert");
        productOrder.setProductName("REMPEYEK UDANG + TELOR ASIN + IKAN TONGKOL + NASI SETENGAH");
        productOrder.setStatus("Confirm");

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("EDWIN PURNAMA");
        customerInfo.setEmail("edwin.purnama@indocyber.co.id");
        customerInfo.setAddress("Ciledug");

        productOrder.setCustomerInfo(customerInfo);
        return productOrder;
    }
}
