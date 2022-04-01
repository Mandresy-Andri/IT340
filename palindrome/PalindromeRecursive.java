package com.palindrome;

/**
 * author: Mandresy Andriamasinoro
 *
 * I check palindrome from the middle then expand outward
 */
public class PalindromeRecursive {

    public boolean findPalindrome(String word){
        //if word is even so start from two different points
        if(word.length()%2==0) {
            if (checkLeftAndRight(word, word.length() / 2-1, word.length()/2)) return true;
        }
        else
        //if word is odd so start from same point
        if(checkLeftAndRight(word,word.length()/2,word.length()/2))return true;
        return false;
    }

    //recursive method
    public boolean checkLeftAndRight(String word, int left, int right){
        //if pointers are out of bounds or if chars don't match then return false
        if(left<0 || right>=word.length() || word.charAt(left)!=word.charAt(right)){
            return false;
        }
        //if pointers arrive at the end then word return true
        else if(left==0 && right==word.length()-1 )
            return true;
        //call method again and pass next index for each pointer
        if(checkLeftAndRight(word,left-1,right+1))return true;
        return false;
    }

    public static void main(String[] args) {
        if(new PalindromeRecursive().findPalindrome("cristiano"))
            System.out.println("palindrome");
        else
            System.out.println("not palindrome");
    }
}
