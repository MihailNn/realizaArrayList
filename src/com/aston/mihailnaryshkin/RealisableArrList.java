package com.aston.mihailnaryshkin;

public interface RealisableArrList<E> extends Iterable<E> {
    boolean add(E value);
    void delete(int index);
    E get(int index);
    void  update(int index, E value);
    int size();
}
