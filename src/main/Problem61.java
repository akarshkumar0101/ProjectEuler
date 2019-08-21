package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem61 {

    public static void main(String... args){
        List<Integer> list = new ArrayList<>();
        Set<Integer> typesAvailable = new HashSet<>();
        for(int type=0;type<=5;type++){
            typesAvailable.add(type);
        }

        search(list,typesAvailable);
        //System.out.println(list);

        int total = 0;
        for(int num:list){
            total+=num;
        }
        System.out.println(total);
    }

    public static boolean search(List<Integer> list, Set<Integer> typesAvailable){
        if(list.size()==6){
            int first = list.get(0),last = list.get(list.size()-1);
            if(first/100==last%100) {
                return true;
            }
        }
        int rangeStart, rangeEnd;
        if(list.isEmpty()){
            rangeStart = 1000;
            rangeEnd = 10000;
        }
        else{
            int last = list.get(list.size()-1);
            last = last%100;
            if(last<10){
                //can't produce a four digit number
                return false;
            }
            rangeStart = last*100;
            rangeEnd = (last+1)*100;
        }

        for(int num=rangeStart; num<rangeEnd; num++){
            //types the number is
            Set<Integer> types = getTypes(num);
            //types the number can represent (from what is available)
            types.retainAll(typesAvailable);

            list.add(num);
            for(int type: types){
                typesAvailable.remove(type);

                if(search(list,typesAvailable)){
                    return true;
                }

                typesAvailable.add(type);
            }
            list.remove(list.size()-1);

        }
        return false;
    }



    /*
    Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
    Square	 	    P4,n=n^2	 	    1, 4, 9, 16, 25, ...
    Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
    Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
    Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
    Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...

    Tri:        1/2 * n^2 + 1/2 * n
    Square:           n^2
    Pentagonal: 3/2 * n^2 - 1/2 * n
    Hexagonal:  2/1 * n^2 - 1/1 * n
    Heptagonal: 5/2 * n^2 - 3/2 * n
    Octagonal:  3/1 * n^2 - 2/1 * n
     */

    public static Set<Integer> getTypes(int y){
        Set<Integer> types = new HashSet<>();

        for(int type = 0; type<=5;type++){
            if(isType(y,type)){
                types.add(type);
            }
        }

        return types;
    }

    //type goes from 0 (tri) to 5 (oct)
    public static boolean isType(double y, int type){
        double a = 1.0/2.0 * (type+1);
        double b = 1.0/2.0 * (1-type);
        double ans = -b;
        ans += Math.sqrt(b*b+4*a*y);
        ans/=(2*a);
        return ans%1==0;
    }

}
