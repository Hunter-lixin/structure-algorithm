package com.algorithm.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetContains {
    public static void main(String[] args) {
        Set<Map<String, String>> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("offerId", "10101010");
            map.put("offerName", "销售品");
            set.add(map);
        }

        System.out.println(set.size());
    }
}
