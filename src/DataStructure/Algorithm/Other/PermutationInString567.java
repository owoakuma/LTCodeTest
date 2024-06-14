package DataStructure.Algorithm.Other;

public class PermutationInString567 {//双指针滑动窗口算法
    public static boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int[] charCount = new int[26]; // 【总欠账表】：s1的词频表
        for (char c : str1) { // 统计s1的词频
            charCount[c - 'a']++;
        }
        int l = 0, r = 0; // 滑动窗口左右边界
        // 依次尝试固定以s2中的每一个位置l作为左端点开始的len1长度的子串s2[l ... l+len1)是否是s1的排列
        while (l <= len2 - len1) { // 固定左端点只需要尝试到len2-len1即可
            // 右边界s2[r]字符进入窗口【还账】
            while (r < l + len1 && charCount[str2[r] - 'a'] >= 1) {
                charCount[str2[r] - 'a']--; // 【"还账"】
                r++;
            }
            if (r == l + len1) return true;
            // 左边界s2[l]字符出窗口【赊账】，l++，开始尝试固定下一个位置做左端点
            charCount[str2[l] - 'a']++; // 重新【"赊账"】
            l++;
        }
        return false; // 所有的左端点均尝试还账失败，不可能再有答案了
    }
}
