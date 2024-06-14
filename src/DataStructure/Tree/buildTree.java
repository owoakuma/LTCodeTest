package DataStructure.Tree;

public class buildTree<AnyType>{
    boolean isTree=true;
    public BinaryTree<AnyType> build(AnyType[] inOrder,AnyType[] postOrder){
        if(inOrder.length!=postOrder.length){
            System.out.println("unable to build a binary tree!");
            return null;
        }
        BinaryTree<AnyType> binaryTree=new BinaryTree<>(building(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1));
        if(!isTree){
            System.out.println("unable to build a binary tree!");
            return null;
        }
        else
            return binaryTree;
    }
    private TreeNode<AnyType> building(AnyType[] inorder, int inStart, int inEnd,
                                       AnyType[] postorder, int postStart, int postEnd){
        if(inStart>inEnd)
            return null;
        if(inStart==inEnd){
            if(postorder[postStart]==inorder[inStart])
                return new TreeNode<>(postorder[postEnd]);
            else {
                isTree=false;
                return null;
            }
        }
        TreeNode<AnyType> node=new TreeNode<>(postorder[postEnd]);
        int index=-1;
        for(int i=inEnd;i>=inStart;i--){
            if(inorder[i]==postorder[postEnd])
            {
                index=i;
                break;
            }
        }
        if(index==-1){
            isTree=false;
            return null;
        }
        int leftSize=index-inStart;
        node.left=building(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        node.right=building(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return node;
    }
}
