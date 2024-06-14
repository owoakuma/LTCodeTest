package DataStructure.Algorithm.Other;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        List<Integer[]> list=new ArrayList<>();
        for(int[] ints : envelopes){
            Integer[] integers= Arrays.stream(ints).boxed().toArray(Integer[]::new);
            list.add(integers);
        }
        list.sort((o1, o2) -> (o1[0].compareTo(o2[0])!=0)? o1[0].compareTo(o2[0]):o2[1].compareTo(o1[1]));
        int cout=0;
        for(Integer[] integers: list){
            int[] ints=Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
            envelopes[cout]=ints;
            cout++;
        }
        int[] dp=new int[envelopes.length];
        dp[0] = envelopes[0][1];
        int size=1;
        for(int i=1;i<envelopes.length;i++){
            int left=0;
            int right=size-1;
            while (left<=right){
                System.out.println(Arrays.toString(dp));
                int middle=left+ (right-left)/2;
                if(envelopes[middle][1]>=envelopes[i][1]){
                    right=middle-1;
                }
                else {
                    left=middle+1;
                }
            }
            dp[right+1]=envelopes[i][1];
            if(right+1==size)
                size++;
        }
        return size;
    }
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length==1){
            return matrix[0][0];
        }
        int[][] dp=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            dp[i] =(int []) matrix[i].clone();
        }
        for(int i=1;i<matrix.length;i++){
            dp[i][0]+=Math.min(dp[i-1][0],dp[i-1][1]);
            for(int j=1;j<matrix.length-1;j++){
                dp[i][j]+=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]));
            }
            dp[i][matrix.length-1]+=Math.min(dp[i-1][matrix.length-2],dp[i-1][matrix.length-1]);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            min=Math.min(dp[matrix.length-1][i],min);
        }
        return min;
    }
}

