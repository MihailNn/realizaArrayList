package com.aston.mihailnaryshkin;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class RealizeArrayList is a realization of own ArrayList
 * @param <E>
 */

public class RealizeArrayList<E> implements RealisableArrList<E> {

    private E[] array;

    public RealizeArrayList() {
        array = (E[]) new Object[0];
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

        System.out.println(integers);
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIteratorImp<>(array);
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
            E[] tempArray = array;
            array = (E[]) new Object[tempArray.length + 1];
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
            E[] temArray = array;
            array = (E[]) new Object[temArray.length - 1];
            System.arraycopy(temArray, 0, array, 0, index);
            System.arraycopy(temArray, index + 1, array, index,temArray.length - index - 1 );
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public void update(int index, E value) {
        array[index] = value;
    }

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

    public RealizeArrayList<Integer> quickSort(RealizeArrayList<Integer> arList){

        if(arList.size() <= 1){
            return arList;
        }

        int middle = (int) Math.ceil((double)arList.size() / 2);
        int pivot = arList.get(middle);

        RealizeArrayList<Integer> less = new RealizeArrayList<Integer>();
        RealizeArrayList<Integer> greater = new RealizeArrayList<Integer>();

        for (int i = 0; i < arList.size(); i++) {
            if(arList.get(i) <= pivot){
                if(i == middle){
                    continue;
                }
                less.add(arList.get(i));
            }
            else{
                greater.add(arList.get(i));
            }
        }

        return concatenate(quickSort(less), pivot, quickSort(greater));
    }

    /**
     * Join the less array, pivot integer, and greater array
     * to single array.
     * @param less integer ArrayList with values less than pivot.
     * @param pivot the pivot integer.
     * @param greater integer ArrayList with values greater than pivot.
     * @return the integer ArrayList after join.
     */
    public RealizeArrayList<Integer> concatenate(RealizeArrayList<Integer> less, int pivot,
                                                  RealizeArrayList<Integer> greater) {

        RealizeArrayList<Integer> list = new RealizeArrayList<Integer>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }

        return list;
    }
}
