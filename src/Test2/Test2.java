package Test2;


import DataStructure.Algorithm.Other.MazeSolver;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        File maze=new File("D:\\maze.in");
        if(!maze.exists()){
            throw new FileNotFoundException("maze is not found!");
        }
        BufferedReader bf = new BufferedReader(new FileReader(maze));
        String size=bf.readLine();
        int r=Integer.parseInt(size.substring(0,1));
        int c=Integer.parseInt(size.substring(size.length()-1,size.length()));
        char[][] chars=new char[r][c];
        for(int i=0;i<r;i++){
            chars[i]=bf.readLine().toCharArray();
        }
        List<char[][]> list=MazeSolver.solve(chars);
        if(list.isEmpty()){
            System.out.println("impossible!");
            return;
        }
        for(char[][] chars1:list){
            for(int i=0;i<r;i++){
                System.out.println(Arrays.toString(chars1[i]));
            }
            System.out.println();
        }
    }
}
