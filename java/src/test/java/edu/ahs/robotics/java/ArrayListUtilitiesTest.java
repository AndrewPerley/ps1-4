package edu.ahs.robotics.java;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ArrayListUtilitiesTest {


    @Test
    public void testArrayList() {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("hello");
        myList.add("heat");
        myList.add("heart");
        for (int i = 0; i < myList.size(); i++) {
            String message = myList.get(i);
            System.out.println(message);
        }



    }


    @Test
    public void searchArrayList() {

        ArrayList<String> arraySearch = new ArrayList<>();
        arraySearch.add("hi");
        arraySearch.add("chive");
        arraySearch.add("bye");
        String target = ("hi");

            assertTrue(ArrayListUtilities.searchArrayList(target,arraySearch));
    }

    @Test
    public void integerArrayList() {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(6);
        integers.add(7);
        int largestInteger = ArrayListUtilities.highestNumber(integers);

        assertEquals(7,largestInteger);



    }

    @Test
    public void removeValuesGreaterThan() {

        ArrayList<Integer> originalList = new ArrayList<>();
        originalList.add(5);
        originalList.add(-7);
        originalList.add(2);
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(5);
        expectedList.add(2);
        assertEquals(expectedList,ArrayListUtilities.removeValuesGreaterThan(originalList,1));

    }

    @Test
    public void removeValuesGreaterThanNegative() {

        ArrayList<Integer> originalList = new ArrayList<>();
        originalList.add(-95);
        originalList.add(-7);
        originalList.add(-2);
        ArrayList<Integer> expectedList = new ArrayList<>();
        //expectedList.add(5);
        //expectedList.add(2);
        assertEquals(expectedList,ArrayListUtilities.removeValuesGreaterThan(originalList,1));

    }
}


