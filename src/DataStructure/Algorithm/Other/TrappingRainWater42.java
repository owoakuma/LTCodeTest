package DataStructure.Algorithm.Other;

public class TrappingRainWater42 {//接雨水,问题见https://leetcode.cn/problems/trapping-rain-water/
    //双指针问题
    //
    //对于每一个柱子接的水，那么它能接的水=min(左右两边最高柱子）-当前柱子高度
    //
    // 假设左右指针指向柱子序号分别为 i，j。那么就有 iLeftMax,iRightMax,jLeftMx,jRightMax 这个变量。由于 j>i ，故 jLeftMax>=iLeftMax，iRightMax>=jRightMax.
    //
    //那么，如果 iLeftMax>jRightMax，则必有 jLeftMax >= jRightMax，所有我们能接 j 点的水。
    //
    //如果 jRightMax>iLeftMax，则必有 iRightMax >= iLeftMax，所以我们能接 i 点的水。
    //
    //而上面我们实际上只用到了 iLeftMax，jRightMax 两个变量，故我们维护这两个即可。
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);//更新max值
            rightMax = Math.max(rightMax, height[right]);//更新max值
            if (leftMax<rightMax) {//接left点的水
                ans += leftMax - height[left];
                ++left;
            } else {//接right点的水
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
