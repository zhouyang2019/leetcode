package com.zy;

public class Printer {

    public static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(", ");
        }
        System.out.println(sb.toString());
    }

}
