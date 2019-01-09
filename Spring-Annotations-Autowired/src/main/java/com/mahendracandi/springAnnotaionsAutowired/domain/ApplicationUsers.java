package com.mahendracandi.springAnnotaionsAutowired.domain;

import org.springframework.stereotype.Component;

@Component("applicationUser")
public class ApplicationUsers {
    private String name = "Mahendra Candi";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApplicationUsers{" + "name='" + name + '\'' + '}';
    }
}
