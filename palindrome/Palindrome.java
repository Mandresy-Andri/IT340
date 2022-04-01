package com.palindrome;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome {

    /*
     * Implement this method and return true if the word is the same
     * forward and backwards
     * Do not use automatic methods for reversing the string
     */
    private boolean isPalindrome(String word) {
        //check if the word is the same from both ends
        //stop when index of var start is greater than var end
        for(int start=0,end=word.length()-1;start<end;start++,end--){
            if(word.charAt(start)!=word.charAt(end))
                return false;
        }
        return true;
    }
    /*
     * Open up  the file.
     * Break into words
     *  print out all Palindromes
     */
    private void findAllPalindromes(String fileName) throws FileNotFoundException {
        //Use scanner to get input from file
        Scanner scan = null;
        //create file object with path of the file
        File file = new File(fileName);
        //initialize scan object and pass it the file
        //surround with try-catch if file not found
        try{
            scan = new Scanner(file);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //continue while file has more words
        while(scan.hasNext()){
            //store next word in lowerCase in var and print if palindrome
            String word=scan.next().toLowerCase();
            if(isPalindrome(word)) //word is passed to isPalindrome method to check if it is palindrome
                System.out.println(word);
        }
    }
    public Palindrome() throws FileNotFoundException {
        //test case for findAllPalindromes
        findAllPalindromes("C:\\Users\\andri\\Documents\\Codes\\IT340\\src\\com\\palindrome\\gutenberg.txt");

        //run some tests
//        if (isPalindrome("racecar")) {
//            System.out.print("pass");
//        }
//        else {
//            System.out.print("Fail");
//        }
//        if (isPalindrome("mom")) {
//            System.out.print("pass");
//        }
//        else {
//            System.out.print("Fail");
//        }
//        if (isPalindrome("noon")) {
//            System.out.print("pass");
//        }
//        else {
//            System.out.print("Fail");
//        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        new Palindrome();

    }

}