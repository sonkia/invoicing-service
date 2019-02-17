package com.finers.invoicing.utils;

import java.util.UUID;

public class Generator {

    public static String genUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
