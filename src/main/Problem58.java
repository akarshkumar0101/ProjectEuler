package main;

public class Problem58 {
    //bottom left diagonal grows at +8, +16,+24
    //                             dx=+8

    //top right diagonal grows at +2, +10, +18
    //                             dx=+8

    //top left diagonal grows at +4, +12, +20
    //                             dx=+8

    //bottom left diagonal grows at +6, +14, +22
    //                             dx=+8

    //these are all quadratic series bc the second derivative is constant
    public static void main(String... args){

        int primesSoFar = 0;
        int r;
        for(r=1;;r++){
            int numberInDiagonals = r*4+1;

            primesSoFar += primesAtRadius(r);

            //System.out.println(r+" "+numberInDiagonals+" "+primesSoFar);
            double percentage = (double)primesSoFar/numberInDiagonals;
//            if(r%100==0)
//                System.out.println(r+" "+percentage);
            if(percentage<0.1){
                break;
            }
        }
        System.out.println(2*r+1);

    }
    public static int numberInDiagonals(int squareWidth){
        int r = (squareWidth-1)/2;
        return r*4+1;
    }
    //the center is r=0
    public static int primesAtRadius(int r){
        int topLeft = modelingFunc(r,5);
        int topRight = modelingFunc(r,3);
        int botLeft = modelingFunc(r,7);
        //int botRight = modelingFunc(r,9);

        int numPrimes = 0;

        if(isPrime(topLeft)){
            numPrimes++;
        }
        if(isPrime(topRight)){
            numPrimes++;
        }
        if(isPrime(botLeft)){
            numPrimes++;
        }
//        if(isPrime(botRight)){
//            numPrimes++;
//        }


        return numPrimes;
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int modelingFunc(int inp, int starting){
        //d/dx^2 = 8
        //d/dx = 8x + C1
        //f = 4x^2 + C1x + C2
        //because when x=0, f = 1 (starting point), C2=1
        //C1 depends on starting
        //f = 4x^2 + C1x + 1
        //f = starting when x = 1
        //f = 4 + C1 + 1 = starting, so C1 = starting - 5

        //f = 4x^2 + (starting-5)*x + 1

        return 4*inp*inp+(starting-5)*inp+1;
    }
}
