package com.aston.mihailnaryshkin;

import java.util.Iterator;

public class ArrayIteratorImp<E> implements Iterator<E> {
    private int index = 0;
    private E[] array;

    public ArrayIteratorImp(E[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public E next() {
        return array[index+1];
    }
}
