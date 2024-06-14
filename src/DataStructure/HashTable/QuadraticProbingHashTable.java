package DataStructure.HashTable;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class QuadraticProbingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 11;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {//set the tale size
        allocateArray(size);
        clear();
    }

    public void clear() {
        currentSize = 0;
        Arrays.fill(array, null);
    }

    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(AnyType x) {
        int currentPos = findPos(x);
        if(isActive(currentPos))
            return;
        array[currentPos]=new HashEntry<>(true,x);
        if(++currentSize>array.length/2)
            rehash();
    }


    public void remove(AnyType x) {//lazy deletion
        int currentPos=findPos(x);
        if(isActive(currentPos))
           array[currentPos].isActive=false;
    }

    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;//if the element is detected, it will be set to false

        public HashEntry(AnyType x) {
            this(true, x);
        }

        public HashEntry(boolean isActive, AnyType x) {
            element = x;
            this.isActive = isActive;
        }
    }

    private HashEntry<AnyType>[] array;//the array of the elements
    private int currentSize;//the number of active element

    private void allocateArray(int size) {
        array =new  HashEntry[nextPrime(size)];
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myHash(x);
        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos > array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    private void rehash() {
        HashEntry<AnyType>[] oldArray=array;
        allocateArray(array.length*2);
        currentSize=0;
        for(HashEntry<AnyType> hashEntry:oldArray){
            if(hashEntry!=null&&hashEntry.isActive){
                insert(hashEntry.element);
            }
        }
    }

    private int myHash(AnyType x) {
        int hashVal = x.hashCode() % array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    private static int nextPrime(int n) {//find the next prime behind n
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        int i;
        for (i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
