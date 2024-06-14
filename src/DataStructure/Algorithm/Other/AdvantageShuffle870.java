package DataStructure.Algorithm.Other;

import java.util.List;

public class AdvantageShuffle870 {//双指针
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        sort(nums1); // 田忌的马
        sort(nums2); // 齐王的马

// 从最快的马开始比
        for (int i = n - 1; i >= 0; i--) {
            if (nums1[i] > nums2[i]) {
                // 比得过，跟他比
            } else {
                // 比不过，换个垫底的来送人头
            }
        }
        return nums1;
    }
    private void sort(int [] nums){

    }
}
