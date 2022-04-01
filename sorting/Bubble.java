package com.sorting;

import java.util.Arrays;

/**
 author: Mandresy Andriamasinoro
 Bubble Sorting Class
 */

public class Bubble {

    public int[] bubbleSort(int[] array){
        int index=1;
        int temp=0;
        boolean flip=false;
        //go through all index
        while(index<array.length) {
            if(array[index]<array[index-1]) {//if current value is greater than the one before then flip
                temp = array[index - 1];
                array[index-1]=array[index];
                array[index]=temp;
                flip=true;//indicate a flip was done
            }
            if(index==array.length-1 & flip){//if end of array and there was a flip then go back
                index=1;
                flip=false;
            }
            else if(index==array.length & !flip)//if end of array and there was no flip then stop loop
                break;
            else //else just increment index
                index++;
        }
    return array;
    }

    //same algorithm but using compareToIgnoreCase to compare values
    public String[] bubbleSortString(String[] array){
        int index=1;
        String temp="";
        boolean flip=false;
        //go through all index
        while(index<array.length) {
            if(array[index].compareToIgnoreCase(array[index-1])<0) {//if current value is greater than the one before then flip
                temp = array[index - 1];
                array[index-1]=array[index];
                array[index]=temp;
                flip=true;//indicate a flip was done
            }
            if(index==array.length-1 & flip){//if end of array and there was a flip then go back
                index=1;
                flip=false;
            }
            else if(index==array.length & !flip)//if end of array and there was no flip then stop loop
                break;
            else //else just increment index
                index++;
        }
        return array;
    }

    public Bubble(){
        //test cases
        System.out.println(Arrays.toString(bubbleSort(new int[] {5,2,4,3,10,7,1,9,6,8})));
        System.out.println(Arrays.toString(bubbleSortString(new String[]{"banana","apple","carrot","cardamon","donut","taco","pasta","mushrooms"})));
    }

    public static void main(String[] args) {
        new Bubble();
    }
}

