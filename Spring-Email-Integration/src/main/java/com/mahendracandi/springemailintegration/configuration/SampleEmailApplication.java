package com.mahendracandi.springemailintegration.configuration;

import com.mahendracandi.springemailintegration.model.CustomerInfo;
import com.mahendracandi.springemailintegration.model.ProductOrder;
import com.mahendracandi.springemailintegration.services.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SampleEmailApplication {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.sendOrderConfirmation(getProductOrder());
        context.close();
    }

    private static ProductOrder getProductOrder(){
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrderId("12345-qwert");
        productOrder.setProductName("Rempeyek udang + telor asin + ikan tongkol + nasi setengah");
        productOrder.setStatus("Confirm");

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("Abdu Mahendra");
        customerInfo.setEmail("muhammad.abdu@indocyber.co.id");
        customerInfo.setAddress("Ciledug");

        productOrder.setCustomerInfo(customerInfo);
        return productOrder;
    }
}
