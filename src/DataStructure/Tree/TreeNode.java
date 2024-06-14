package DataStructure.Tree;

public class TreeNode<AnyType> {
      public AnyType val;
      public TreeNode<AnyType> left;
      public TreeNode<AnyType> right;
      public TreeNode() {}
       public TreeNode(AnyType val) { this.val = val; }
       public TreeNode(AnyType val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
