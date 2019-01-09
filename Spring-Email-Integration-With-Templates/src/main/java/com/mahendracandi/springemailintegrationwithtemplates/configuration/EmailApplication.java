package com.mahendracandi.springemailintegrationwithtemplates.configuration;

import com.mahendracandi.springemailintegrationwithtemplates.model.CustomerInfo;
import com.mahendracandi.springemailintegrationwithtemplates.model.ProductOrder;
import com.mahendracandi.springemailintegrationwithtemplates.service.OrderService;
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
        productOrder.setOrderId("1234-4321");
        productOrder.setProductName("LAPTOP MAC BREBET VERSI 99");
        productOrder.setStatus("Confirm");

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("ABDU MAHENDRA");
        customerInfo.setEmail("muhammad.abdu@indocyber.co.id");
        customerInfo.setAddress("KEMARIN");

        productOrder.setCustomerInfo(customerInfo);
        return productOrder;
    }
}
