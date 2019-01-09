package com.mahendracandi.springAnnotaionsAutowired.domain;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// component adalah anotasi yang akan membuat kelas ini menjadi bean
// component adalah hirarki tertinggi dari @service, @repository, @controller
@Component("application")
public class Application {

    //resource adalah anotasi untuk membuat bean sama seperti autowired=byName pada xml
    //anotasi resource sama saja dengan autowired
    @Resource(name = "applicationUser")
    private ApplicationUsers applicationUsers;

    @Override
    public String toString() {
        return "Application{" + "applicationUsers=" + applicationUsers + '}';
    }
}
