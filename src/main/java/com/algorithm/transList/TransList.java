package com.algorithm.transList;

import java.util.*;

public class TransList {

    public static List<Map<String, String>> transList(List<Map<String, String>> mapList) {
        Set<String> addressIdSet = new HashSet<>();
        for (Map<String, String> map : mapList) {
            addressIdSet.add(String.valueOf(map.get("addressId")));
        }

        List<Map<String, String>> resultList = new ArrayList<>(addressIdSet.size());
        for (String addressId : addressIdSet) {
            Map<String, String> resultMap = new HashMap<>();
            StringBuilder offerIdsSb = new StringBuilder();
            for (Map<String, String> map : mapList) {
                if (addressId.equals(String.valueOf(map.get("addressId")))) {
                    offerIdsSb.append(map.get("offerId")).append(",");
                }
            }
            resultMap.put("addressId", addressId);
            resultMap.put("offerIds", offerIdsSb.substring(0, offerIdsSb.toString().length() - 1));
            resultList.add(resultMap);
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("offerId", "1");
        map1.put("addressId", "addressId1");
        mapList.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("offerId", "2");
        map2.put("addressId", "addressId1");
        mapList.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("offerId", "3");
        map3.put("addressId", "addressId1");
        mapList.add(map3);

        Map<String, String> map4 = new HashMap<>();
        map4.put("offerId", "4");
        map4.put("addressId", "addressId2");
        mapList.add(map4);

        Map<String, String> map5 = new HashMap<>();
        map5.put("offerId", "5");
        map5.put("addressId", "addressId2");
        mapList.add(map5);

        Map<String, String> map6 = new HashMap<>();
        map6.put("offerId", "6");
        map6.put("addressId", "addressId2");
        mapList.add(map6);

        System.out.println(transList(mapList));

    }
}
