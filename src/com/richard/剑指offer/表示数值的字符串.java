package com.richard.剑指offer;

public class 表示数值的字符串 {

    public boolean isNumeric (String s) {
        try {
            if(Double.valueOf(s.toString())!=null)
                return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
