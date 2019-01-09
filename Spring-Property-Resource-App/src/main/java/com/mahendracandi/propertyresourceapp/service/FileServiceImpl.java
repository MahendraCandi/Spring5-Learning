package com.mahendracandi.propertyresourceapp.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService{
    final static Logger log = Logger.getLogger(FileServiceImpl.class);

    @Autowired
    private Environment environment;

    // format anotasi @Value adalah
//    @value("${key:default")
//    private String var;
    // key adalah kata kunci yg mengambil value dari file properties
    // default adalah value default jika key pada file properties tidak ditemukan
    // mengambil value dari properties juga bisa menggunakan interface environtment dari spring
    // tinggal panggil methodnya environtment.getProperty();

    @Value("${sourceLocation:c:/bengbeng}")
    private String sourceLocation;

    @Value("${jdbc.url}")
    private String url;

    @Value("${kucing:aku kucing nakal}")
    private String undefinedProperty;

    @Value("${hewan:guk guk}")
    private String hewan;

    @Override
    public void readValues() {
        log.debug("Getting property via spring environtment : " + environment.getProperty("jdbc.username"));
        log.debug("URL : " + url);
        log.debug("Source Location : " + sourceLocation);
        log.debug("Undefined Property : " + undefinedProperty);
        log.debug("Hewan : " + hewan);
    }
}
