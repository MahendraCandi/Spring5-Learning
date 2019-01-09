package com.mahendracandi.springAnnotaionsAutowired.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("driver")
public class Driver {

    //@Autowired //autowired by field
    private License licenseField;

    @Autowired //autowired by constructor
    public Driver(License licenseField) {
        this.licenseField = licenseField;
    }

    public License getLicense() {
        return licenseField;
    }

    //@Autowired //autowired di method setter
    public void setLicense(License license) {
        this.licenseField = license;
    }

    @Override
    public String toString() {
        return "Driver{" + "license=" + licenseField + '}';
    }
}
