package com.mahendracandi.springjmsactivemqproducerex1.util;

import java.util.UUID;

public class BasicUtil {
    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
