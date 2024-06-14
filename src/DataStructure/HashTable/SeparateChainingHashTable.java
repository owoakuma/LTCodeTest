package DataStructure.HashTable;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class SeparateChainingHashTable<AnyType> {
    public SeparateChainingHashTable() {//Constructors
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {//Constructors
        lists = new List[nextPrime(size)];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public void insert(AnyType x) {
        List<AnyType> theList = lists[myHash(x)];
        if (!theList.contains(x)) {
            theList.add(x);
            if (++currentSize > lists.length) {
                rehash();
            }
        }
    }

    public void remove(AnyType x) {
        List<AnyType> theList = lists[myHash(x)];
        if (theList.contains(x)) {
            theList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(AnyType x) {
        return lists[myHash(x)].contains(x);
    }

    public void clear() {//重置分离链接哈希表
        for (List<AnyType> list : lists) {
            list.clear();
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<AnyType>[] lists;
    private int currentSize;

    private void rehash() {
        List<AnyType>[] oldLists=lists;
        lists=new List[nextPrime(lists.length*2)];
        currentSize=0;
        for(int i=0;i<lists.length;i++){
            lists[i]=new LinkedList<>();
        }
    }

    private int myHash(AnyType x) {
        int hashVal = x.hashCode() % lists.length;
        if (hashVal < 0) {
            hashVal += lists.length;
        }
        return hashVal;
    }

    private static int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        int i;
        for (i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {// 如果不为素数返回0
                return false;
            }
        }
        return true;
    }
}
