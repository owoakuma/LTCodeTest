package Test4;

import DataStructure.Tree.BinaryTree;
import DataStructure.Tree.buildTree;

import java.util.List;

public class test4 {
    public static void main(String[] args) {
        char[] pre="ABCD##E###FGH##I##J##".toCharArray();
        Character[] characters=new Character[pre.length];
        for(int i=0;i<pre.length;i++){
            characters[i]=pre[i];
        }
        BinaryTree<Character> binaryTree=new BinaryTree<>(characters,'#');
        List<Character> midPrint = binaryTree.midPrint();
        System.out.println(midPrint);
        buildTree<Integer> buildTree=new buildTree<>();
        Integer[] postOrder=new Integer[]{4,5,3,2,8,9,7,0,6,1};
        Integer[] inOrder=new Integer[]{4,3,5,2,1,8,7,9,6,0};
        BinaryTree<Integer> integerBinaryTree=buildTree.build(inOrder,postOrder);
        System.out.println(integerBinaryTree.prePrint());
    }
}
