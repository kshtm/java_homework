package com.epam.java.core.task4;

import org.apache.commons.math3.util.Precision;

public class Solution4 {

    public void searchMaxPair(double[] array) {
        int head = 0;
        int tail = array.length - 1;
        double max = Double.MIN_VALUE;
        while (head < tail) {
            double sum = array[head] + array[tail];
            if((Precision.compareTo(sum, max, 0.0001) > 0)) {
                max = sum;
            }
            head++;
            tail--;
        }
        System.out.println("Maximum pair = " + max);
    }

    public static void main(String[] args) {
        double[] array1 = {12, 345, 700.56, 3, 55, 673, 1000, 1};
        double[] array2 = {10, 12, 1, 12, 10};
        Solution4 solution4 = new Solution4();
        solution4.searchMaxPair(array1);
        solution4.searchMaxPair(array2);
    }
}
