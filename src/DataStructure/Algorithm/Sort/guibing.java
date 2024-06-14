package DataStructure.Algorithm.Sort;


import java.util.Arrays;
import java.util.Comparator;

public class guibing {
    public static  <AnyType> void solution(AnyType [] arr, Comparator<AnyType> comparator){
        solution1(arr,comparator,0,arr.length-1);
    }
    public static  <AnyType extends Comparable<AnyType>> void solution(AnyType[] arr){
        solution1(arr,0,arr.length-1);
    }
    private static <AnyType extends Comparable<AnyType>> void solution1(AnyType[] arr,int init,int end){
        if(init<end){
            int middle=init+(end-init)/2;
            solution1(arr,init,middle);
            solution1(arr,middle+1,end);
            solutionSort(arr,init,middle,end);
        }
    }
    private static <AnyType> void solution1(AnyType[] arr, Comparator<AnyType> comparator,int init,int end){
        if(init<end){
            int middle=init+(end-init)/2;
            solution1(arr,comparator,init,middle);
            solution1(arr,comparator,middle+1,end);
            solutionSort(arr,comparator,init,middle,end);
        }
    }
    private static <AnyType> void solutionSort(AnyType[] arr,Comparator<AnyType> comparator,int init,int middle,int end){
        AnyType[] anyTypes1 = Arrays.copyOfRange(arr, init, middle + 1);
        AnyType[] anyTypes2 = Arrays.copyOfRange(arr,middle+1,end+1);
        int i=init;
        int j = middle+1;
        int m= init;
        for(;i<=middle&&j<=end;m++){
            if(comparator.compare(anyTypes1[i-init],anyTypes2[j-middle-1])>0){
                arr[m]=anyTypes2[j-middle-1];
                j++;
            }
            else{
                arr[m]=anyTypes1[i-init];
                i++;
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
    }
    private static <AnyType extends Comparable<AnyType>> void solutionSort(AnyType[] arr,int init,int middle,int end){
        AnyType[] anyTypes1 = Arrays.copyOfRange(arr, init, middle + 1);
        AnyType[] anyTypes2 = Arrays.copyOfRange(arr,middle+1,end+1);
        int i=init;
        int j = middle+1;
        int m= init;
        for(;i<=middle&&j<=end;m++){
            if(anyTypes1[i-init].compareTo(anyTypes2[j-middle-1])>0){
                arr[m]=anyTypes2[j-middle-1];
                j++;
            }
            else{
                arr[m]=anyTypes1[i-init];
                i++;
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
    }
}
