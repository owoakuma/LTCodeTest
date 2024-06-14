package DataStructure.Algorithm.Other;

import java.util.Arrays;

public class Nixu {
    public <AnyType extends Comparable<AnyType>> int solution(AnyType[] arr){
       return solution1(arr,0,arr.length-1);
    }
    private <AnyType extends Comparable<AnyType>> int solution1(AnyType[] arr,int init,int end){
        if(init<end){
            int middle=init+(end-init)/2;
            return solution1(arr,init,middle)+ solution1(arr,middle+1,end)+ solutionSort(arr,init,middle,end);
        }
        return 0;
    }
    private <AnyType extends Comparable<AnyType>> int solutionSort(AnyType[] arr,int init,int middle,int end){
        AnyType[] anyTypes1 = Arrays.copyOfRange(arr, init, middle + 1);
        AnyType[] anyTypes2 = Arrays.copyOfRange(arr,middle+1,end+1);
        int sum=0;
        int x= middle-init+1;
        int i=init;
        int j = middle+1;
        int m= init;
        for(;i<=middle&&j<=end;m++){
            if(anyTypes1[i-init].compareTo(anyTypes2[j-middle-1])>0){
                arr[m]=anyTypes2[j-middle-1];
                j++;
                sum+=x;
            }
            else{
                arr[m]=anyTypes1[i-init];
                i++;
                x--;
            }
        }
        if(i==middle+1)
            for(;j<=end;j++,m++){
                arr[m]=anyTypes2[j-middle-1];
            }
        else
            for(;i<=middle;i++,m++){
                arr[m]=anyTypes1[i-init];
            }
            return sum;
    }
}
