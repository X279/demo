package com.example.webService;

import java.util.regex.Pattern;

public class varifyMailAddress {
    private final String address;

    public varifyMailAddress(String address) {
        this.address = address;
    }

    //验证匹配返回Y，不匹配返回N
    public String varify(){
        String pattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean isMatch = Pattern.matches(pattern, address);
        if(isMatch){
            return "Y";
        }
        return "N";
    }

    public String getAddress(){
        return address;
    }
}
