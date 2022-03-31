package com.aston.mihailnaryshkin;

import org.junit.Test;

import static org.junit.Assert.*;

public class RealizeArrayListTest {

    @Test
    public void testAdding() {

        //Given list of Integers
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        //when adding in arrayList value
        integers.add(6);
        integers.add(3);

        //recieve value
        int adding1 = integers.get(0);
        int adding2 = integers.get(1);

        //then we recive
        int test1 = 6;
        int test2 = 3;

        assertEquals(test1, adding1);
        assertEquals(test2, adding2);
    }

    @Test
    public void testDelete() {
        //Given list of Integers
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        integers.add(6);
        integers.add(9);
        integers.add(3);

        //when delete from arrayList by index 1
        integers.delete(1);

        int deleting = integers.get(1);

        //then there is no value 9 by this index
        int test = 9;

        assertNotEquals(test, deleting);
    }

    @Test
    public void testGet() {
        //Given list of Integers
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        integers.add(6);
        integers.add(9);
        integers.add(3);

        //when get value by index 1
        int get9 = integers.get(1);

        //then we should get the value 9
        int getting = 9;

        assertEquals(getting, get9);
    }

    @Test
    public void testUpdate() {
        //Given list of Integers
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        integers.add(6);
        integers.add(9);
        integers.add(3);

        //when we updete value to 5 by index 1
        integers.update(1, 5);

        //then we should get the value 5 instead of old value 9
        int getting = integers.get(1);

        assertNotEquals(9, getting);
        assertEquals(5, getting);
    }

    @Test
    public void testSize() {
        //Given list of Integers with size 3
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        integers.add(6);
        integers.add(9);
        integers.add(3);

        //when we invoke method size on owr list
        int givenSize = integers.size();

        //then we should get the value 3

        assertEquals(3, givenSize);
    }

    @Test
    public void testQuickSort() {
        //Given list of Integers
        RealizeArrayList<Integer> integers = new RealizeArrayList<>();
        integers.add(2);
        integers.add(7);
        integers.add(5);
        integers.add(3);
        integers.add(1);

        //when we invoke method quickSort
        RealisableArrList<Integer> newIntegers = integers.quickSort();

        //then we should get sorted arrayList
        RealizeArrayList<Integer> integers2 = new RealizeArrayList<>();
        integers2.add(1);
        integers2.add(2);
        integers2.add(3);
        integers2.add(5);
        integers2.add(7);

        assertEquals(integers2, newIntegers);
    }


}