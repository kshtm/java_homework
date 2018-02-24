package com.epam.java.core.task3;

public class Solution3 {

    public void tgTable(int a, int b, int h) {
        for(int i = a; i <= b; i += h) {
            double f = Math.tan(2 * i) - 3;
            System.out.println(i + "\t" + f);
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.tgTable(1, 1000, 12);

    }
}
