package com.designPattern.IteratorPattern;

/**
 * 抽象迭代器
 */
public interface AbstractIterator {
    void next();

    boolean isLast();

    void previous();

    boolean isFirst();

    Object getNextItem();

    Object getPreviousItem();
}
