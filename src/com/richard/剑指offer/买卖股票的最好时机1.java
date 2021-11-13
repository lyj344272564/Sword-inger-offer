package com.richard.剑指offer;

public class 买卖股票的最好时机1 {

    public int maxProfit (int[] prices) {
        // write code here
        int res = 0;
        for (int i=0,min=Integer.MAX_VALUE; i<prices.length; i++) {
            res = Math.max(res,prices[i]-min);
            min = Math.min(prices[i],min);
        }
        return res;
    }
}
