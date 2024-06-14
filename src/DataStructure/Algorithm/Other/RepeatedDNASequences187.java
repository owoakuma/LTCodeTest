package DataStructure.Algorithm.Other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences187 {//Rabin-Karp 算法https://leetcode.cn/problems/repeated-dna-sequences/
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result=new ArrayList<>();
        if(s.length()<10){
            return result;
        }
        int left=0;
        int right=0;
        int windowHash=0;
        HashSet<Integer> seen=new HashSet<>();
        while (right<s.length()){
            windowHash=windowHash*4+Switch(s.charAt(right));
            right++;
            if(right-left==10){
                if(!seen.contains(windowHash)){
                    seen.add(windowHash);
                }
                else {
                    String sub=s.substring(left,right);
                    if(!result.contains(sub)){
                        result.add(sub);
                    }
                }
                windowHash-=Switch(s.charAt(left))*Math.pow(4,9);
                left++;
            }
        }
        return result;
    }
    private int Switch(char c){
        return switch (c) {
            case 'A' -> 0;
            case 'G' -> 1;
            case 'C' -> 2;
            case 'T' -> 3;
            default -> 10;
        };
    }
}
