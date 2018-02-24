package com.epam.java.core.task2;
import org.apache.commons.math3.util.Precision;

public class Solution2 {

    public void searchElement(double e, int n) {
        for(int i = 1; i <= n; i++) {
            double a = 1/Math.pow(i + 1, 2);
            System.out.println("a[" + i + "] = " + a);
            if(Precision.compareTo(a, e, 0.0001) < 0) {
                System.out.println("Found minimal index = " + i);
                return;
            }
        }
        System.out.println("No such element");
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.searchElement(0.01,10);
        solution2.searchElement(0.01, 2);
    }
}
