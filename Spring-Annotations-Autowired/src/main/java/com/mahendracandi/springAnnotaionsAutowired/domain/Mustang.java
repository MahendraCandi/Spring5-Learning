package com.mahendracandi.springAnnotaionsAutowired.domain;

import org.springframework.stereotype.Component;

@Component
public class Mustang implements Car {
    public void getCarName() {
        System.out.println("This Mustang");
    }
}
