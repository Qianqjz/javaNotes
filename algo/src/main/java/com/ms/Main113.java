package com.ms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//  3 0 fang 90 yang 50 ning 70
public class Main113 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            int t=scan.nextInt();
            Student[] stu=new Student[n];
            for (int i=0;i<n;i++){
                String input=scan.nextLine().trim();
                int soc=scan.nextInt();
                stu[i]=new Student(input,soc);
            }
            sort(t,stu);
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<stu.length;i++){
                builder.append(stu[i].name).append(" ").append(stu[i].score).append("\n");
            }
            System.out.println(builder.toString());
        }
    }

    private static void sort(int t, Student[] stu) {
        if(t==0){
            Arrays.sort(stu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.score-o2.score;
                }
            });
        }else if(t==1){
            Arrays.sort(stu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o2.score-o1.score;
                }
            });
        }
    }

    static class Student{
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
