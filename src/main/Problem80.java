package main;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem80 {

    public static void main(String[] args) {


        int total = 0;
        for(int n=2;n<100;n++){
            double sqrt = Math.sqrt(n);
            if(sqrt%1==0){
               continue;
            }
            int sumDigits = sumDigits(n);
            total+= sumDigits;
            //System.out.println(n+": "+sumDigits);
        }
        System.out.println(total);
    }

    public static int sumDigits(int n){
        BigInteger S = new BigInteger(n+"");

        BigInteger denom = new BigInteger("1");
        for(int i=0;i<100;i++){
            denom = denom.multiply(BigInteger.TEN);
        }
        denom = denom.multiply(denom);

        BigInteger num = denom.multiply(S);

        String str = num.sqrt().toString();
        str = str.substring(0,100);
        //System.out.println(str);
        //System.out.println(str.length());

        int sum = 0;
        for(char c:str.toCharArray()){
            sum+=(c-'0');
        }
        return sum;
    }
}
