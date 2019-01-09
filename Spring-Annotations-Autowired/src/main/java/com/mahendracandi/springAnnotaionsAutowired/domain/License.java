package com.mahendracandi.springAnnotaionsAutowired.domain;

import org.springframework.stereotype.Component;

@Component
public class License {
    String number = "1234567890ABCD";

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "License{" + "number='" + number + '\'' + '}';
    }
}
