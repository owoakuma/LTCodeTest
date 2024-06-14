package DataStructure.Algorithm.Sort;

import java.util.Comparator;



public class QuickSort {
    private static final int CUT_OFF = 20;//使用插入排序的截止大小

    public static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static <AnyType> void sort(AnyType[] array, Comparator<? super AnyType> comparator) {
        quicksort(array, comparator, 0, array.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] array, int left, int right) {
        if (left + CUT_OFF <= right) {
            AnyType pivot = median3(array, left, right);
            int i = left;
            int j = right - 1;
            while (i < j){
                while (array[++i].compareTo(pivot)<0){}
                while (array[--j].compareTo(pivot)>0){}
                if(i < j){
                    swapReference(array,i,j);
                }
            }
            swapReference(array,i,right-1);
            quicksort(array,left,i-1);
            quicksort(array,i,right);
        }
        else {
            insertionSort(array,left,right);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] array, int left, int right) {
        int j;
        for(int p =left+1;p<=right;p++){
            AnyType temp = array[p];
            for(j = p;j>left&&temp.compareTo(array[j-1])<0;j--){
                array[j]=array[j-1];
            }
            array[j] =temp;
        }
    }
    private static <AnyType> void insertionSort(AnyType[] array,Comparator<? super AnyType> comparator, int left, int right) {
        int j;
        for(int p =left+1;p<=right;p++){
            AnyType temp = array[p];
            for(j = p;j>left&&comparator.compare(temp,array[j-1])<0;j--){
                array[j]=array[j-1];
            }
            array[j] =temp;
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] array, int left, int right) {
        int center = (left + right) / 2;
        if (array[center].compareTo(array[left]) < 0) {
            swapReference(array, left, center);
        }
        if (array[right].compareTo(array[left]) < 0) {
            swapReference(array, right, left);
        }
        if (array[right].compareTo(array[center]) < 0) {
            swapReference(array, right, center);
        }
        swapReference(array, center, right - 1);
        return array[right - 1];
    }

    private static <AnyType> void quicksort(AnyType[] array, Comparator<? super AnyType> comparator, int left, int right) {
        if (left + CUT_OFF <= 20) {
            AnyType pivot = median3(array,comparator, left, right);
            int i = left;
            int j = right - 1;
            while (i < j){
                while (comparator.compare(array[++i],pivot)<0){}
                while (comparator.compare(array[--j],pivot)>0){}
                if(i < j){
                    swapReference(array,i,j);
                }
            }
            swapReference(array,i,right-1);
            quicksort(array,comparator,left,i-1);
            quicksort(array,comparator,i,right);
        }
        else {
            insertionSort(array,comparator,left,right);
        }
    }

    private static <AnyType> void swapReference(AnyType[] array, int a, int b) {
        AnyType temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    private static <AnyType> AnyType median3(AnyType[] array,Comparator<? super AnyType> comparator, int left, int right) {
        int center = (left + right) / 2;
        if (comparator.compare(array[center],array[left]) < 0) {
            swapReference(array, left, center);
        }
        if (comparator.compare(array[right],array[left])  < 0) {
            swapReference(array, right, left);
        }
        if (comparator.compare(array[right],array[center])  < 0) {
            swapReference(array, right, center);
        }
        swapReference(array, center, right - 1);
        return array[right - 1];
    }
}
