package DataStructure.Algorithm.Other;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        boolean [] elements = new boolean[128];
        for(int right =0;right<s.length();right++){
            char c = s.charAt(right);
            if(!elements[c]){
                elements[c] = true;
            }
            else {
                max = Math.max(max,right-left);
                while (s.charAt(left)!=c){
                    if(elements[s.charAt(left)]){
                        elements[s.charAt(left)] = false;
                    }
                    left++;
                }
                left++;
            }
        }
        max = Math.max(max,s.length()-left);
        return max;
    }
}
