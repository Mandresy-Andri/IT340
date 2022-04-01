package com.sorting;

import java.util.Arrays;

/**
 author: Mandresy Andriamasinoro
 Insertion Sorting Class
 */

public class Insertion {

    public int[] insertionSort(int[] array){
        //check all indexes one by one
        for(int currentCheckedIndex = 1; currentCheckedIndex <array.length; currentCheckedIndex++){
            boolean inserted=false;
            int temp=0;
            int before=0;
            //check each index before the one currently being checked
            while(before<=currentCheckedIndex){
                //if no insertion was done yet and if an index has a higher value than the one being checked
                if(array[currentCheckedIndex]<array[before] & inserted==false){
                    temp=array[before];//store value of previous index temporarily
                    array[before]=array[currentCheckedIndex];//replace value by current value
                    inserted=true;//mark that insertion was made
                }
                //if a number was already inserted then just shift the values to next index
                else if(inserted==true){
                    int temp2= array[before];
                    array[before]=temp;//replace value with the value of previous index that was stored in temp
                    temp=temp2;
                }
                before++;
            }
        }
        return array;
    }

    //same algorithm but using compareToIgnoreCase to compare values
    public String[] insertionSortString(String[] array){
        //check all indexes one by one
        for(int currentCheckedIndex = 1; currentCheckedIndex < array.length; currentCheckedIndex++){
            boolean inserted=false;
            String temp="";
            int before=0;
            //check each index before the one currently being checked
            while(before<=currentCheckedIndex){
                //if no insertion was done yet and if an index has a higher value than the one being checked
                if(array[currentCheckedIndex].compareToIgnoreCase(array[before])<0 & inserted==false){ //compareTo instead of "<" operator
                    temp= array[before];//store value of previous index temporarily
                    array[before]= array[currentCheckedIndex];//replace value by current value
                    inserted=true;//mark that insertion was made
                }
                //if a number was already inserted then just shift the values to next index
                else if(inserted==true){
                    String temp2= array[before];
                    array[before]=temp;//replace value with the value of previous index that was stored in temp
                    temp=temp2;
                }
                before++;
            }
        }
        return array;
    }

    public Insertion(){
        //test cases
        System.out.println(Arrays.toString(insertionSort(new int[] {5,2,4,3,10,7,1,9,6,8})));
        System.out.println(Arrays.toString(insertionSortString(new String[]{"banana","apple","carrot","cardamon","donut","taco","pasta","mushrooms"})));
    }

    public static void main(String[] args) {
        new Insertion();
    }
}
