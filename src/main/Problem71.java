package main;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem71 {

    public static void main(String... args){
        double target = (double)3/7;
        Ratio targetRatio = new Ratio(new BigInteger("3"), new BigInteger("7"));
        double estimate = 1;

        Ratio ans = null;
        for(int d=1;d<=1000000;d++){
            int n = d*3/7;

            Ratio ratio = new Ratio(BigInteger.valueOf(n), BigInteger.valueOf(d));

            double dec = (double) n/d;
            if(target-dec<estimate && !ratio.equals(targetRatio)){
                estimate = target-dec;
                //System.out.println(estimate);
                ans = ratio;
            }
        }
        //System.out.println(ans.a +" / "+ans.b);
        System.out.println(ans.a);
    }

    static class Ratio {
        BigInteger a, b;

        public Ratio(BigInteger a, BigInteger b){
            this.a = a;
            this.b = b;
            simplify();
        }
        public void simplify(){
            BigInteger gcd = a.gcd(b);
            a = a.divide(gcd);
            b = b.divide(gcd);
        }

        public boolean equals(Object another){
            return another instanceof Ratio && ((Ratio)another).a.equals(a) && ((Ratio)another).b.equals(b);
        }
    }
}
