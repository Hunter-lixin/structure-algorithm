package com.designPattern.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        AbstractObjectList list = new ProductList(products);
        list.addObject("倚天剑");
        list.addObject("屠龙刀");
        list.addObject("断肠草");
        list.addObject("葵花宝典");
        list.addObject("四十二章经");

        AbstractIterator iterator = list.createIterator();

        System.out.println("正向遍历:");
        while (!iterator.isLast()) {
            System.out.print(iterator.getNextItem());
            iterator.next();
            if (!iterator.isLast()) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("----------------------");

        System.out.println("逆向遍历：");
        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem());
            iterator.previous();
            if (!iterator.isFirst()) {
                System.out.print(", ");
            }
        }
    }
}
