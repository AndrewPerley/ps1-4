package edu.ahs.robotics.java;

import java.util.ArrayList;

public class ArrayListUtilities {

    public static boolean searchArrayList(String target, ArrayList<String> arraySearch) {
        for (int i = 0; i < arraySearch.size(); i++) {
            if (target == ("hi")) {
                return true;
            }

        }
        return false;
    }


    public static int highestNumber(ArrayList<Integer> integers) {

        int largestInteger = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if(largestInteger < integers.get(i)){
                largestInteger = integers.get(i);
            }
        }
        return largestInteger;
    }

    public static ArrayList<Integer> removeValuesGreaterThan(ArrayList<Integer> originalList, Integer decisionInt){
        ArrayList<Integer> actual = new ArrayList<>() ;

        for (int i = 0; i < originalList.size(); i++) {
            if(originalList.get(i) > decisionInt) {
                actual.add(originalList.get(i));
            }


        }

        return actual;
    }

}