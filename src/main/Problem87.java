package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem87 {

    public static void main(String[] args) {


        int limit = 50000000;
        List<Integer> primes = getPrimes((int)Math.sqrt(limit)+1);


        Set<Integer> representable = new HashSet<Integer>();

        //int tot = 0;

        for(int pa: primes) {
            int sqr = pa * pa;
            if (sqr > limit) {
                break;
            }
            for (int pb : primes) {
                int cube = pb * pb * pb;
                if (sqr + cube > limit) {
                    break;
                }
                for (int pc : primes) {
                    int quad = pc * pc * pc * pc;
                    if (sqr + cube + quad > limit) {
                        break;
                    }

                    representable.add(sqr + cube + quad);
                    //tot++;

                }
            }
        }
        //System.out.println(tot);
        System.out.println(representable.size());
    }
    public static List<Integer> getPrimes(int limit){
        List<Integer> list = new ArrayList<>();

        for(int n=2;n<limit;n++){
            if(isPrime(n)){
                list.add(n);
            }
        }
        return list;
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        double sqrt = Math.sqrt(n);
        for(int i=2;i<=sqrt;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
}
