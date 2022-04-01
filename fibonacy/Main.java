package com.fibonacy;

public class Main {

    public static void main(String[] args) {
        System.out.println("The fibonacci numbers are :\n0\n1");
        int current=0;
        int next=1;
        int temp=0;
        for (int count=0;count<40;count++){
            System.out.println(current+next);
            temp=current+next;
            current=next;
            next=temp;
        }
    }
}
