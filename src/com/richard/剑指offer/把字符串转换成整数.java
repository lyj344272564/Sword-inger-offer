package com.richard.剑指offer;

public class 把字符串转换成整数 {

    public int StrToInt (String str) {
        // 去掉空格
        char[] chars = str.trim().toCharArray();

        if (0 == chars.length) {
            return 0;
        }

        // 判断正负数  正数则为true
        boolean positive = true;

        // 从第几位开始
        int start = 1;

        // 如果第一位是符号位则用positive   若不是符号位则从第1位开始存储
        if ('-' == chars[0]) {
            positive = false;
        } else if ('+' != chars[0]){
            start = 0;
        }

        long res = 0;
        for (int i=start; i<chars.length; i++) {
            if (chars[i]<'0' || chars[i]>'9') {
                break;
            }
            res = res*10 + (chars[i]-'0');
            //如果越界根据正负号返回结果
            if(res > Integer.MAX_VALUE) {
                return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }

        return positive?(int)res:(int)(-1*res);
    }
}
