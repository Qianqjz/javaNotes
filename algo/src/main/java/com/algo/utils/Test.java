package com.algo.utils;

import java.util.*;

class SingleTest{
    private volatile static SingleTest unIqueneton;

    public SingleTest() {
    }

    public SingleTest getInstance(){
        if (unIqueneton==null){
            synchronized (SingleTest.class){
                if (unIqueneton==null){
                    unIqueneton=new SingleTest();
                }
            }
        }
        return unIqueneton;
    }
}

public class Test {

    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        StringBuffer stringBuffer=new StringBuffer();
        String string=new String();

        List<Integer> list=new ArrayList<Integer>();
        List<String> list1=new LinkedList<String>();
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(9);
        list.add(1);
        list.add(8);

        Collections.sort(list);
        Collections.swap(list,0,1);
        Collections.frequency(list,8);

        Object[] array = list.toArray();
    }
}
