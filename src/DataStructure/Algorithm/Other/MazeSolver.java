package DataStructure.Algorithm.Other;

import MyCollection.List.MyArrayStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MazeSolver {
    public static List<char[][]> solve(char[][] maze) throws CloneNotSupportedException {
        char[][] used=new char[maze.length][maze[0].length];
        int rStart = 0,lStart = 0;
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(maze[i][j]=='@'){
                    rStart=i;
                    lStart=j;
                }
                used[i][j]='0';
            }
        }
        List<MyArrayStack<int[]>> result=new LinkedList<>();
        List<char[][]> result1=new LinkedList<>();
        findWay(rStart, lStart, maze,used,result,new MyArrayStack<>());
        for(MyArrayStack<int[]> myArrayStack :result){
            char[][] solved=new char[maze.length][];
            for(int i=0;i<maze.length;i++){
                solved[i]=maze[i].clone();
            }
            System.out.println();
            while (!myArrayStack.isEmpty()){
                int[] a=myArrayStack.pop();
                solved[a[0]][a[1]]='*';
            }
            solved[rStart][lStart]='@';
            System.out.println();
            result1.add(solved.clone());
        }
        return result1;
    }
    private static boolean findWay(int r,int c,char[][] maze,char[][] used,List<MyArrayStack<int[]>> list,MyArrayStack<int[]> solving) throws CloneNotSupportedException {
        if(r>=maze.length||c>=maze[0].length||r<0||c<0){
            list.add((MyArrayStack<int[]>)solving.clone());
            return true;
        }
        if (maze[r][c] != '=' && used[r][c] != '1') {
            solving.push(new int[]{r, c});
            used[r][c] = '1';
            boolean f1 = findWay(r + 1, c, maze, used, list, solving);
            if (!f1) {
                boolean f2 = findWay(r - 1, c, maze, used, list, solving);
                if (!f2) {
                    boolean f3 = findWay(r, c + 1, maze, used, list, solving);
                    if (!f3) {
                        findWay(r, c - 1, maze, used, list, solving);
                    }
                }
            }
            solving.pop();
            used[r][c] = '0';
        }
        return false;
    }
}
