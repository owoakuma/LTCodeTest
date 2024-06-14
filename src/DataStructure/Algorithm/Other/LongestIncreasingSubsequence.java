package DataStructure.Algorithm.Other;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0] = 1;
        int maxLength=0;
        for(int i=1;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    max= Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
            maxLength= Math.max(maxLength,max);
            System.out.println(max);
        }

        return maxLength;
    }
}
