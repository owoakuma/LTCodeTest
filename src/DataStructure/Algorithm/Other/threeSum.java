package DataStructure.Algorithm.Other;

import DataStructure.Algorithm.Sort.guibing;

import java.util.ArrayList;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return null;
        }
            guibing guibing=new guibing();
            guibing.solution(nums);
            for(int i=0;nums[i]<=0&&i<=nums.length-2;i++){
                int min=i+1,max=nums.length-1;
                while (min<max){
                    int sum=i;
                    if((sum+=nums[min]+nums[max])<0){
                        min++;
                        continue;
                    }
                    else if(sum>0){
                        max--;
                        continue;
                    }
                    if(min!=i+1){
                    }
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[min]);
                    list.add(nums[max]);
                    list.add(nums[i]);
                    res.add(list);
                }
            }
            return res;
    }
}
