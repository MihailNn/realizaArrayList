package com.aston.mihailnaryshkin;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class RealizeArrayList is a realization of own ArrayList
 * @param <E>
 */

public class RealizeArrayList<E extends Comparable<E>> implements RealisableArrList<E> {

    private Object[] array;

    public RealizeArrayList() {
        array = new Object[0];
    }


    public static void main(String[] args) {
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        integers.add(2);
        integers.add(6);
        integers.add(7);
        integers.add(5);
        integers.add(9);
        integers.add(4);
        integers.add(3);
        integers.add(8);
        integers.add(1);

        RealisableArrList<Integer> newIntegers = integers.quickSort();

        System.out.println(newIntegers);
    }

    /**
     * Method add value to arrayList
     * @param value some value of any  type
     * tempArray is temporary array.
     * array is a target array
     * @return true if value was added to arrayList
     */
    @Override
    public boolean add(E value) {
        try {
            Object[] tempArray = array;
            array = new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, array, 0, tempArray.length);
            array[array.length-1] = value;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    /**
     * Method delete value from arrayList
     * @param index is an index of arrayList which will be deleted
     */

    @Override
    public void delete(int index) {
        try {
            Object[] temArray = array;
            array = new Object[temArray.length - 1];
            System.arraycopy(temArray, 0, array, 0, index);
            System.arraycopy(temArray, index + 1, array, index,temArray.length - index - 1 );
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }
    /**
     * Method return value by index.
     * @param index is an index of arrayList
     */
    @Override
    public E get(int index) {
        return (E) array[index];
    }

    /**
     * Method update value by index.
     * @param index is an index of arrayList
     * @param value is a new value for this element
     */
    @Override
    public void update(int index, E value) {
        array[index] = value;
    }

    /**
     * Method return size (length) of the arrayLis.
     */
    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return "RealizeArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    /**
     * @return method quickSortRecurrsive
     */
    public RealizeArrayList<E> quickSort(){
        return quickSortRecursive(this);
    }

    /**
     * Method in for loop divide values on less or greater then pivot adding
     * them in corresponding arrayLists.
     * Recursively they are sorting
     * @param arList is a arrayList
     * @return method concatenate
     */
    private RealizeArrayList<E> quickSortRecursive(RealizeArrayList<E> arList) {
        if(arList.size() <= 1){
            return arList;
        }

        int middle = (int) Math.ceil((double) arList.size() / 2);
        E pivot = arList.get(middle);

        RealizeArrayList<E> less = new RealizeArrayList<>();
        RealizeArrayList<E> greater = new RealizeArrayList<>();

        for (int i = 0; i < arList.size(); i++) {
            if(arList.get(i).compareTo(pivot) <= 0){
                if(i == middle){
                    continue;
                }
                less.add(arList.get(i));
            }
            else{
                greater.add(arList.get(i));
            }
        }

        return concatenate(quickSortRecursive(less), pivot, quickSortRecursive(greater));
    }

    /**
     * Join the less arrayList, pivot, and greater arrayList to single array.
     * @param less arrayList with values less than pivot.
     * @param pivot the pivot.
     * @param greater arrayList with values greater than pivot.
     * @return the ArrayList after join.
     */
    public RealizeArrayList<E> concatenate(RealizeArrayList<E> less, E pivot,
                                           RealizeArrayList<E> greater) {

        RealizeArrayList<E> list = new RealizeArrayList<>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }

        return list;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIteratorImp<>((E[]) array);
    }
}

