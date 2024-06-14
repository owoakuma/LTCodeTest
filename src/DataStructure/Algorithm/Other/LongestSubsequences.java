package DataStructure.Algorithm.Other;

import java.util.Arrays;

public class LongestSubsequences {//https://leetcode-cn.com/problems/longest-common-subsequence/
    public int longestCommonSubsequence(String text1, String text2) {
        int [] dp= new int[text2.length()+1];
        Arrays.fill(dp,0);
        int topLeft;
        int left;
        for(int i=1;i<=text1.length();i++){
            topLeft=0;
            left=0;
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    left = dp[j];
                    dp[j]=topLeft+1;
                    topLeft = left;
                    left = dp[j];
                }
                else {
                    topLeft = dp[j];
                    dp[j] = Math.max(left,dp[j]);
                    left = dp[j];
                }
            }
        }
        return dp[text2.length()];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder stringBuffer= new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            stringBuffer.append(s.charAt(i));
        }
        String s1 =  stringBuffer.toString();
        return longestCommonSubsequence(s,s1);
    }
    public int minInsertions(String s) {
        int n = longestPalindromeSubseq(s);
        return s.length()-n;
    }
}
