package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Problem79 {
    public static final File file = new File("/Users/akarshkumar0101/Developer/ProjectEuler/res/p079_keylog.txt");
    public static void main(String... args) {

        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> logins = new ArrayList<>();
        while(scan.hasNextLine()){
            logins.add(scan.nextLine());
        }
        scan.close();


        //value indicates visited or not
        Set<Integer> allVertices = new HashSet<>();
        Map<Integer, Set<Integer>> edgesFromVertices = new HashMap<>();
        for(String login:logins){
            for(char c:login.toCharArray()) {
                int num = c - '0';
                allVertices.add(num);
                if(!edgesFromVertices.containsKey(num)) {
                    edgesFromVertices.put(num, new HashSet<>());
                }
            }
            int num1 = login.charAt(0)-'0';
            int num2 = login.charAt(1)-'0';
            int num3 = login.charAt(2)-'0';
            edgesFromVertices.get(num2).add(num1);
            edgesFromVertices.get(num3).add(num2);
        }
        List<Integer> availableVertices = new ArrayList<>();
        for(int v: allVertices){
            if(edgesFromVertices.get(v).isEmpty()){
                availableVertices.add(v);
            }
        }
        //now we have graph for topological sorting
        List<Integer> sortedList = new ArrayList<>();

        while(!availableVertices.isEmpty()){
            int v = availableVertices.remove(0);
            sortedList.add(v);
            System.out.print(v);

            for(int nextV: allVertices){
                if(edgesFromVertices.get(nextV).contains(v)){
                    edgesFromVertices.get(nextV).remove(v);
                    if(edgesFromVertices.get(nextV).isEmpty()){
                        availableVertices.add(nextV);
                    }
                }
            }
        }
        System.out.println();


        //topologicalSort(7,visitedVertices,edgesFromVertices,sortedList);

//        while(!sortedList.isEmpty()){
//            //System.out.print(sortedList.pop());
//        }
    }

    //DFS Topological Sort
//    public static void topologicalSort(int vertex, Map<Integer,Boolean> visitedVertices, Map<Integer,Set<Integer>> edgesFromVertices, Stack<Integer> sortedList){
//        visitedVertices.put(vertex,true);
//        for(int v: edgesFromVertices.get(vertex)){
//            if(!visitedVertices.get(v)){
//                topologicalSort(v,visitedVertices,edgesFromVertices,sortedList);
//            }
//        }
//        sortedList.push(vertex);
//    }



}
