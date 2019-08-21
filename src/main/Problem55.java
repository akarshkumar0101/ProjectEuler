package main;

import java.math.BigInteger;

public class Problem55 {
    public static void main(String... args){

        //System.out.println(isLychrel(4994));
        int total = 0;
        for(int i=1;i<10000;i++){
            if(isLychrel(i)){
                total++;
            }
        }
        System.out.println(total);
    }

    public static boolean isLychrel(int num){
        BigInteger n = new BigInteger(num+"");

        for(int i=0;i<50;i++){
            n = nextIteration(n);
            if(isPalindrome(n.toString())){
                return false;
            }
        }
        return true;
    }

    public static BigInteger nextIteration(BigInteger num){
        return num.add(reverse(num));
    }
    public static boolean isPalindrome(String str){
        int len = str.length();
        for(int i=0; i <len/2;i++){
            if(str.charAt(i) != str.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
    public static BigInteger reverse(BigInteger num){
        return new BigInteger(reverse(num.toString()));
    }
    public static String reverse(String inp){
        String str = "";
        for(int i=inp.length()-1;i>=0;i--){
            str+=inp.charAt(i);
        }
        return str;
    }
}
