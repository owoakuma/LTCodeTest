package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AVLTree<AnyType extends Comparable<AnyType>> {
    private static class AVLNode<AnyType extends Comparable<AnyType>> {
        AnyType element;
        AVLNode<AnyType> leftNode;
        AVLNode<AnyType> rightNode;
        int height;

        AVLNode(AnyType thisElement, AVLNode<AnyType> left, AVLNode<AnyType> right) {
            element = thisElement;
            leftNode = left;
            rightNode = right;
            height = 0;
        }

        AVLNode(AnyType thisElement) {
            this(thisElement, null, null);
        }
    }

    private static final int ALLOWED_IMBALANCE = 1;//允许的最大高度差

    public AVLTree() {
        this.root = null;
    }

    public AVLTree(AnyType root) {
        this.root = new AVLNode<>(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public void printTree() {
        List<AnyType> list = new ArrayList<>();
        midPrint(root, list);
        System.out.println(list);
    }

    public void insert(AnyType x) {
        this.root=insert(x, root);
    }

    public void remove(AnyType x) {
        remove(x, root);
    }

    public AnyType findMax(){
        return findMax(root);
    }

    public AnyType findMin(){
        return findMin(root);
    }

    private AnyType findMax(AVLNode<AnyType> t) {
        if (t.rightNode != null) {
            return findMax(t.rightNode);
        } else
            return t.element;
    }

    private AnyType findMin(AVLNode<AnyType> t) {
        if (t.leftNode != null) {
            return findMin(t.leftNode);
        } else
            return t.element;
    }

    private void midPrint(AVLNode<AnyType> root, List<AnyType> list) {
        if (root == null)
            return;
        midPrint(root.leftNode, list);
        list.add(root.element);
        midPrint(root.rightNode, list);
    }

    private boolean contains(AnyType x, AVLNode<AnyType> root) {
        if (root == null) {
            return false;
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult > 0) {
            return contains(x, root.rightNode);
        } else if (compareResult < 0) {
            return contains(x, root.leftNode);
        } else
            return true;
    }

    private int height(AVLNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    private AVLNode<AnyType> root;


    /*递归插入*/
    private AVLNode<AnyType> insert(AnyType x, AVLNode<AnyType> t) {
        if (t == null) {
            return new AVLNode<>(x);
        }/*结束条件*/

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.leftNode = insert(x, t.leftNode);/*递归插入左子树*/
        } else if (compareResult > 0) {
            t.rightNode = insert(x, t.rightNode);/*递归插入右子树*/
        }

        return balance(t);/*平衡二叉树*/
    }

    private AVLNode<AnyType> remove(AnyType x, AVLNode<AnyType> t) {//递归删除
        if (t == null) {
            throw new NoSuchElementException();
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.leftNode = remove(x, t.leftNode);
        } else if (compareResult > 0) {
            t.rightNode = remove(x, t.rightNode);
        } else if (t.leftNode != null && t.rightNode != null) {
            double random = Math.random();
            if (random > 0.5) {
                t.element = findMin(t.rightNode);
                t.rightNode = remove(x, t.rightNode);
            } else {
                t.element = findMax(t.leftNode);
                t.leftNode = remove(x, t.leftNode);
            }
        } else
            t = (t.leftNode != null) ? t.leftNode : t.rightNode;
        return balance(t);
    }


    private AVLNode<AnyType> balance(AVLNode<AnyType> t) {
        if (t == null)
            return null;
        if (height(t.leftNode) - height(t.rightNode) > ALLOWED_IMBALANCE) {//非平衡
            if (height(t.leftNode.leftNode) > height(t.leftNode.rightNode)) {//左左情况
                t = rotateWithLeftChild(t);
            } else//左右情况
                t = doubleWithLeftChild(t);
        } else if (height(t.rightNode) - height(t.leftNode) > ALLOWED_IMBALANCE) {//非平衡
            if (height(t.rightNode.rightNode) > height(t.rightNode.leftNode)) {//右右情况
                t = rotateWithRightChild(t);
            } else
                t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.leftNode), height(t.rightNode)) + 1;
        return t;
    }

    private AVLNode<AnyType> rotateWithLeftChild(AVLNode<AnyType> t) {//单旋转
        AVLNode<AnyType> k2 = t.leftNode;
        t.leftNode = k2.rightNode;
        k2.rightNode = t;
        t.height = Math.max(height(t.leftNode), height(t.rightNode)) + 1;
        k2.height = Math.max(height(k2.leftNode), t.height) + 1;
        return k2;
    }

    private AVLNode<AnyType> doubleWithLeftChild(AVLNode<AnyType> t) {//双旋转
        t.leftNode = rotateWithRightChild(t.leftNode);
        return rotateWithLeftChild(t);
    }

    private AVLNode<AnyType> rotateWithRightChild(AVLNode<AnyType> t) {
        AVLNode<AnyType> k2 = t.rightNode;
        t.rightNode = k2.leftNode;
        k2.leftNode = t;
        t.height = Math.max(height(t.leftNode), height(t.rightNode)) + 1;
        k2.height = Math.max(height(k2.rightNode), t.height) + 1;
        return k2;
    }

    private AVLNode<AnyType> doubleWithRightChild(AVLNode<AnyType> t) {
        t.rightNode = rotateWithLeftChild(t.rightNode);
        return rotateWithRightChild(t);
    }
}

