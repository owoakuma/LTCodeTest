package DataStructure;

import DataStructure.Algorithm.Other.KoKoEatingBananas875;
import DataStructure.Algorithm.Sort.QuickSort;

import java.util.Arrays;

public class Run {
    public static void main(String[] args){
        Integer[] ints = new Integer[100];
        for(Integer i=0;i<100;i++){
            ints[i] = (int)(20 * Math.random());
        }
        System.out.println(Arrays.toString(ints));
        QuickSort.sort(ints);
        System.out.println(Arrays.toString(ints));
        
    }
}
