package Course_B;

import DataStructure.Tree.AVLTree;
public class test {
    public static void main(String[] args) {
//        List<student> students=FileIO.fileInput("D://students.txt");
//        Sort sort=new Sort(students);
//        sort.sortByID();
//        FileIO.fileOutput("D://students.txt",students);
        AVLTree<Integer> avlTree=new AVLTree<>();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(11);
        avlTree.printTree();
        System.out.println(avlTree.findMax());
    }
}
