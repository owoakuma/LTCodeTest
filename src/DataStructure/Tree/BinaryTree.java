package DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<AnyType> {
    private int nodeNumber=0;
    private int border=0;
    private TreeNode<AnyType> root;
    private AnyType nullMark;
    private int pointer = 0;
    public BinaryTree(AnyType nullMark){
        this.root= new TreeNode<>();
        this.nullMark=nullMark;
    }
    public BinaryTree(AnyType[] pre,AnyType nullMark){
        pointer=0;
        this.nullMark=nullMark;
        this.root=preConstruct(pre);
    }
    public BinaryTree(TreeNode<AnyType> root){
        this.root=root;
    }
    public TreeNode<AnyType> getRoot(){
        return root;
    }
    public void setTree(AnyType[] pre){
        pointer=0;
        this.root=preConstruct(pre);
    }
    public void setTree(AnyType[] pre,AnyType nullMark){
        pointer=0;
        this.nullMark=nullMark;
        this.root=preConstruct(pre);
    }
    private TreeNode<AnyType> preConstruct(AnyType[] pre){
        if(pre[pointer]==nullMark||pre==null){
            pointer++;
            return null;
        }
        TreeNode<AnyType> node = new TreeNode<>(pre[pointer]);
        pointer++;
        node.left=preConstruct(pre);
        node.right=preConstruct(pre);
        if(node.left==null&&node.right==null)
            nodeNumber++;
        return node;
    }
    public List<AnyType> midPrint(){
        if(root==null)
            return null;
        List<AnyType> mid=new LinkedList<>();
        midTraverse(root,mid);
        return mid;
    }
    public List<AnyType> postPrint(){
        if(root==null)
            return null;
        List<AnyType> post=new LinkedList<>();
        postTraverse(root,post);
        return post;
    }
    private void midTraverse(TreeNode<AnyType> node,List<AnyType> mid){
        if(node==null){
            return;
        }
        midTraverse(node.left,mid);
        mid.add(node.val);
        midTraverse(node.right,mid);
    }
    private void postTraverse(TreeNode<AnyType> node,List<AnyType> mid){
        if(node==null){
            return;
        }
        midTraverse(node.left,mid);
        midTraverse(node.right,mid);
        mid.add(node.val);
    }
    public List<AnyType> prePrint(){
        if(root==null)
            return null;
        List<AnyType> post=new LinkedList<>();
        preTraverse(root,post);
        return post;
    }
    private void preTraverse(TreeNode<AnyType> node,List<AnyType> mid){
        if(node==null){
            return;
        }
        mid.add(node.val);
        preTraverse(node.left,mid);
        preTraverse(node.right,mid);
    }
    public int getNodeNumber(){
        return nodeNumber;
    }
    public int getBorder(){
        return border;
    }
}
