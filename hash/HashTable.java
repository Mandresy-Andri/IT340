package com.hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
author: Mandresy Andriamasinoro
HashMap Class
 */

public class HashTable {
    //Array size is 10000 words + 20% extra for overflow
    String[] hashTable = new String[12000]; //stores the strings
    int[] overflowPointer = new int[12000]; //stores pointers to the overflow
    int nextFreePlace =11999;//shows next free position in the overflow (starts at last index and goes down)
    int collisionTracker=0;//tracks number of collisions


    //Each word from file is sent to hash method then stored at the hash number returned
    public void storeWords(String fileName){
        Scanner scan = null;
        File file = new File(fileName);
        try{
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNext()){
            String word = scan.next();
            hashTable[hash(word)]=word;
        }
    }


    //Transforms string into index
    public Integer hash(String word){
        //main hash algorithm
        int hashNumber =0;
        for (int i=0; i < word.length(); i++) {
            int number = word.charAt(i);        //turn every letter to ascii number
            hashNumber = (hashNumber + number)*29; //Random algorithm that gave me the best result (best: 38% if you do *29)
        }
        if (hashNumber <0) hashNumber *=-1;         //change number to positive just in case
        if(hashNumber >9999) hashNumber %=9999;     //do modulus 9999 so number doesn't point to overflow (10000 and up is overflow)

        return collision(hashNumber,word); //mitigates possible collision before returning number
    }


    //Main collision mitigation method is overflow
    public Integer collision(int hashNum, String word){
        //If there is nothing at index => hash number is not changed
        if(hashTable[hashNum]==null);

        else {
            //if there is something at index there are different scenarios
            //1st case: the word there is the same as the word we hashed => Hash number is not changed
            if(hashTable[hashNum].equals(word));

            //2nd case: the word there is not the same and there is no pointer yet
            else if(!hashTable[hashNum].equals(word) && overflowPointer[hashNum]==0){
                findNextFreePlace(); //find next free location of overflow
                overflowPointer[hashNum]= nextFreePlace;  //assign the pointer to the current index
                hashNum = nextFreePlace;    //define hashNumber as the new pointer
                collisionTracker++; //increment collision number
            }

            //3rd case: the word stored is not same and there is already a pointer
            else{
                collisionTracker++; //increment collision number
                while (overflowPointer[hashNum]!=0){ //while there is more pointers to follow
                    if(hashTable[hashNum].equals(word)) break; //check if word there matches current word
                    hashNum =overflowPointer[hashNum]; //change index to next pointer
                }
                //after loop ends, if none of the words matched the current one =>
                if(overflowPointer[hashNum]==0 && !hashTable[hashNum].equals(word)){
                    findNextFreePlace(); //find next free location on overflow
                    overflowPointer[hashNum]= nextFreePlace;  //assign the pointer to the current index
                    hashNum = nextFreePlace;    //return the pointer as the hash number
                }
            }
        }
        return hashNum;
    }


    //Decrements the variable nextFreePlace until an empty spot is found
    public void findNextFreePlace(){
        while(nextFreePlace>=0 & hashTable[nextFreePlace]!=null){
            nextFreePlace--;
        }
    }


    //Displays collision number and percentage
    public void calculateCollision(){
        System.out.println("Number of collisions was "+collisionTracker);
        float collisionPercent = ((float) collisionTracker/10000)*100;  //percentage is collision number / word number
        System.out.println("Percentage of collisions is "+collisionPercent+"%");
    }


    public HashTable() {
        storeWords("C:\\Users\\andri\\Documents\\Codes\\IT340\\src\\com\\hash\\words.txt");
        calculateCollision();
        //sample retrieving test
        System.out.println("answer should be: poison");
        System.out.println(hashTable[hash("poison")]);
    }


    public static void main(String[] args) {
        new HashTable();
    }
}
