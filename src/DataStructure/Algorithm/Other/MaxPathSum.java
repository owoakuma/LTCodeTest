package DataStructure.Algorithm.Other;


import DataStructure.Tree.TreeNode;

public class MaxPathSum {
    int max=-65535;
    public int MaxPathSum(TreeNode<Integer> root){
        findMax(root);
        return max;
    }
    int findMax(TreeNode<Integer> node){
        if(node==null){
            return 0;
        }
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        int a=leftMax+ rightMax+node.val;
            if(a>max){
                max=a;
            }
        return Math.max(Math.max(leftMax,rightMax)+node.val,0);
        }
}