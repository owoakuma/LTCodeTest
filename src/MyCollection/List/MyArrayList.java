package MyCollection.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType>,Cloneable {
    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private AnyType[] items;

    public MyArrayList() {
        doClear();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        MyArrayList<AnyType> stu = null;
        try{
            stu = (MyArrayList<AnyType>)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        stu.items=(AnyType[]) this.items.clone();
        return stu;
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size() ==0;
    }
    public void trimToSize(){
        ensureCapacity(size());
    }
    public AnyType get(int index){
        if(index <0||index >=size())
            throw new ArrayIndexOutOfBoundsException();
        return items[index];
    }
    public AnyType set(int index,AnyType newVal){
        if(index <0||index >=size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old=items[index];
        items[index]=newVal;
        return old;
    }
    public void ensureCapacity(int newCapacity){
        if(newCapacity<size)
            return;
        AnyType[] old=items;
        items =(AnyType[]) new Object[newCapacity];
        for(int i = 0;i<size;i++)
        {
            items[i]=old[i];
        }
    }
    public boolean add(AnyType X)
    {
        add(size(),X);
        return true;
    }
    public void add(int index,AnyType x)
    {
        if(items.length == size)
            ensureCapacity(size()*2+1);
        if (size - index >= 0) System.arraycopy(items, index, items, index + 1, size - index);
        items[index]=x;
        size++;
    }
    public AnyType remove(int index)
    {
        AnyType removeItem = items[index];
        if (size - 1 - index >= 0) System.arraycopy(items, index + 1, items, index, size - 1 - index);
        size--;
        return removeItem;
    }
    private class ArrayListIterator implements Iterator<AnyType>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public AnyType next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

}
