package Test5;

public class test5 {
    public static void main(String[] args) {
        testNode node1 = new testNode(1);
        testNode node2 = new testNode(node1);
        testNode node3 = node1;
        node2.elem = 2;
        System.out.println(node1.elem);
    }
}
class testNode{
    int elem;
    public testNode(int elem){
        this.elem = elem;
    }
    public  testNode(testNode other){
        this.elem = other.elem;
    }
}
