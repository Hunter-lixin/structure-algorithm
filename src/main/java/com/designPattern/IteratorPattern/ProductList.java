package com.designPattern.IteratorPattern;

import java.util.List;

/**
 * 商品数据类:具体聚合类
 */
public class ProductList extends AbstractObjectList {

    public ProductList(List products) {
        super(products);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }

}
