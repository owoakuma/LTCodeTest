package DataStructure.Algorithm.Other;

public class ShippingPackagesInDDays1011 {
    //二分搜索寻找最小边界https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/

    public int shipWithinDays(int[] weights, int days) {
        //装货量在最大货物和总货物重量之间
        int left = 0;
        int right = 0;
        //确定左右边界
        for (int cargo : weights) {
            left = Math.max(left, cargo);
            right += cargo;
        }
        int mid;
        while (left <= right){
            mid=left+(right-left)/2;
            int result=packingTest(weights,mid,days);
            if(result<=0){
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return left;
    }
    private int packingTest(int[] weights,int capacity,int days){
        int count=0;
        int loading=0;
        for (int weight : weights) {
            loading += weight;
            if (loading > capacity) {
                count++;
                loading = weight;
            }
            if (count >= days)
                return 1;
        }
        if(count==days)
            return 0;
        else
            return -1;
    }
}