package main;

import java.util.*;
import java.util.function.Consumer;

public class Problem205 {


    public static void main(String[] args) {
        List<Integer> outcomeListPete = new ArrayList<>();
        Map<Integer, Integer> outcomeOccPete = new HashMap<>();

        List<Integer> outcomeListColin = new ArrayList<>();
        Map<Integer, Integer> outcomeOccColin = new HashMap<>();

        Stack<Integer> rolls = new Stack<>();

        roll(rolls, outcomeListPete, outcomeOccPete,9,4);
        roll(rolls, outcomeListColin, outcomeOccColin,6,6);

//        System.out.println(outcomeListPete);
//        System.out.println(outcomeOccPete);
//
//        System.out.println(outcomeListColin);
//        System.out.println(outcomeOccColin);

        long total = 0;
        long numTimesPete = 0;
        for(int outPete: outcomeListPete){
            for(int outColin:outcomeListColin){
                long numOccPete = outcomeOccPete.get(outPete);
                long numOccColin = outcomeOccColin.get(outColin);
                total += numOccPete*numOccColin;

                if(outPete>outColin){
                    numTimesPete += numOccPete*numOccColin;
                }
            }
        }
//        System.out.println(total);
//        System.out.println(numTimesPete);

        System.out.println((double) numTimesPete/(double)total);

    }
    //0.abcdefg
    //0.5731440767829801
    //0.5731441

    public static void roll(Stack<Integer> rolls, List<Integer> outcomeList, Map<Integer, Integer> outcomeOcc, int numDice, int numFaces){
        if(rolls.size()==numDice){
            int sum = 0;
            for(int rollOut: rolls){
                sum+=rollOut;
            }
            if(!outcomeList.contains(sum)){
                outcomeList.add(sum);
            }
            if(outcomeOcc.containsKey(sum)){
                outcomeOcc.put(sum,outcomeOcc.get(sum)+1);
            }
            else{
                outcomeOcc.put(sum,1);
            }
            return;
        }

        for(int rollOut=1;rollOut<=numFaces;rollOut++){
            rolls.push(rollOut);
            roll(rolls,outcomeList, outcomeOcc, numDice, numFaces);
            rolls.pop();
        }

    }

}
