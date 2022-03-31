package com.aston.mihailnaryshkin;

/**
 * Interface with methods for realizable ArrayList
 * @param <E>
 */
public interface RealisableArrList<E extends Comparable<E>> extends Iterable  {
    boolean add(E value);
    void delete(int index);
    E get(int index);
    void  update(int index, E value);
    int size();
}
