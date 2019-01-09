package com.mahendracandi.springAnnotaionsAutowired.domain;

import org.springframework.stereotype.Component;

@Component
public class Ferrari implements Car{
    public void getCarName() {
        System.out.println("This Ferarri");
    }
}
