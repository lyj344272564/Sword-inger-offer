package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 数据流中的中位数 {

    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int index = list.size()/2;
        if (list.size()%2 != 0) {
            return (double) list.get(index);
        } else {
            return ((double) list.get(index-1) + (double) list.get(index))/2;
        }
    }
}
