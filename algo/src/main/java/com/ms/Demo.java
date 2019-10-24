package com.ms;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String str="111 222 333 444 555";
        int i = str.lastIndexOf(" ");
        System.out.println(i);
        System.out.println(str.substring(i).length());
    }
}
