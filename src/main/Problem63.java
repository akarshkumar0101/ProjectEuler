package main;

public class Problem63 {

    public static void main(String[] args) {
        int total = 0;
        for (int n = 1; ; n++) {
            long minNDigitNum = minNum(n);
            long maxNDigitNum = maxNum(n);

            double minNthRoot = Math.pow(minNDigitNum, 1.0 / n);
            double maxNthRoot = Math.pow(maxNDigitNum, 1.0 / n);

//			System.out.println(minNDigitNum+" "+maxNDigitNum);
//			System.out.println(minNthRoot+" "+maxNthRoot);
            int minBase = (int) Math.ceil(minNthRoot);
            int maxBase = (int) maxNthRoot;
//			System.out.println(minBase+" "+maxBase);
            int totalNumsInN = maxBase - minBase + 1;
//			System.out.println(totalNumsInN);

            total += totalNumsInN;

            //System.out.println();

            if (totalNumsInN == 0) {
                break;
            }
        }
        System.out.println(total);

    }


    public static long minNum(int ndigits) {
        return (long) (Math.pow(10, ndigits - 1));
    }

    public static long maxNum(int ndigits) {
        return (long) (Math.pow(10, ndigits) - 1);
    }

}
