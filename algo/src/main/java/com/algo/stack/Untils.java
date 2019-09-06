package com.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Untils {
    public static String getString() throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
