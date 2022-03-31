package com.aston.mihailnaryshkin;

import java.util.Iterator;

/**
 * Class ArrayIteratorImpl is a realization of Iterator
 * with two overriding methods hasNext() and next()
 * @param <E>
 */
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
