package main;

import java.util.*;

public class Problem51 {
    public static void main(String... args){
        List<Long> primes = new ArrayList<>();

        for(long n=2;n<1000000;n++){
            if(isPrime(n)){
                primes.add(n);
            }
        }

        for(int i=0;i<primes.size();i++){
            search(primes.get(i));
        }

    }

    public static void search(long number){
        Set<Byte> repeatingDigits = repeatingDigits(number);

        String str = ""+number;
        for(byte digit:repeatingDigits){
            searchFamily(str,digit,0);
        }
    }
    public static void searchFamily(String fam, byte digit, int indexAt){
        if(indexAt>=fam.length()){
            if(computeFamily(fam)){
            }
            return;
        }
        if((fam.charAt(indexAt)-'0')==digit){
            String fam2 = fam.substring(0,indexAt)+'*'+fam.substring(indexAt+1,fam.length());
            searchFamily(fam2,digit,indexAt+1);
        }

        searchFamily(fam,digit,indexAt+1);

    }


    public static final Set<String> familyStringsFailed = new HashSet<>();
    public static boolean computeFamily(String familyString){
        if(!familyString.contains("*")){
            return false;
        }
        //System.out.println(familyString);
        if(familyStringsFailed.contains(familyString)){
            return false;
        }
        //keep track of how many failed instead of passed (faster)
        int totalNum = 0;
        for(char digit = '0';digit<='9';digit++){
            String newString = familyString.replaceAll("\\*",String.valueOf(digit));
            long number = Long.parseLong(newString);
            if(isPrime(number)){
                totalNum++;
            }
        }
        if(totalNum<8){
            familyStringsFailed.add(familyString);
            return false;
        }
        System.err.println("FOUND: "+familyString);
        return true;
    }

    public static Set<Byte> repeatingDigits(long number){
        Set<Byte> repeats = new HashSet<>();
        Set<Byte> allDigits = new HashSet<>();

        while(number>0){
            byte digit = (byte) (number%10);
            number = number/10;
            if(allDigits.contains(digit)){
                repeats.add(digit);
            }
            else{
                allDigits.add(digit);
            }
        }

        return repeats;
    }

    public static final Map<Long, Boolean> primeMap = new HashMap<>();
    public static boolean isPrime(long num) {
        if (num < 2)
            return false;
        if(primeMap.containsKey(num)){
            return primeMap.get(num);
        }
        boolean isPrime = true;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        primeMap.put(num,isPrime);
        return isPrime;
    }

}
