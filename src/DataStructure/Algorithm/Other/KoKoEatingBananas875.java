package DataStructure.Algorithm.Other;

public class KoKoEatingBananas875 {
    //原理同1011二分搜索寻找最小边界https://leetcode.cn/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        //装货量在最大货物和总货物重量之间
        int left = 1;
        int right = 0;
        //确定左右边界
        for (int cargo : piles) {
            right = Math.max(right, cargo);
        }
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int result = packingTest(piles, mid, h);
            if (result <= 0) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return left;
    }

    private int packingTest(int[] piles, int mid, int days) {
        int count = 0;
        for (int pile : piles) {
            count += pile / mid;
            if(pile%mid>0)
                count++;
            if(count>days)
                return 1;
        }
        if(count==days)
            return 0;
        else
            return -1;
    }
}
