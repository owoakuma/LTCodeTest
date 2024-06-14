package MyCollection.List;

public class MyArrayStack<AnyType> implements Cloneable{
    private MyArrayList<AnyType> list=new MyArrayList<>();
    public void push(AnyType anyType){
        list.add(anyType);
    }
    public AnyType pop(){
        if(list.size()==0)
            return null;
        else
            return list.remove(list.size()-1);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyArrayStack<AnyType> stu = null;
        try{
            stu = (MyArrayStack<AnyType>)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        stu.list=(MyArrayList<AnyType>)this.list.clone();
        return stu;
    }

    public AnyType top(){
        if(list.size()==0)
            return null;
        else
            return list.get(list.size()-1);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
