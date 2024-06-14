package DataStructure.Algorithm.Other;

import java.util.HashMap;

public class minWindow {
    private String minString="";
    private int minLength=65535;
    private HashMap<Character,Integer> need;
    private boolean isValid = false;
    public String minWindow(String s,String t){
        if(s.length()<t.length())
            return "";
        need=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(!need.containsKey(c)){
                need.put(c,1);
            }
            else
                need.put(c,need.get(c)+1);
        }
        windowing(s,t,0,0);
        return minString;
    }
    private void windowing(String s,String t,int left,int right){
            char c=s.charAt(right);
            if(need.containsKey(c)) {
                int num = need.get(c);
                need.put(c, num- 1);
                while(!need.containsKey(s.charAt(left))||need.get(s.charAt(left))<0){
                    if(!need.containsKey(s.charAt(left))){

                        left++;
                    }
                    else {
                        need.put(s.charAt(left),need.get(s.charAt(left))+1);
                        left++;
                    }
                }
                if(!isValid){
                    isValid=true;
                    for(int i=0;i<t.length();i++){
                        if(need.get(t.charAt(i))>0){
                            isValid=false;
                            break;
                        }
                    }
                }
                if(isValid&&right-left<minLength){
                    minString=s.substring(left,right+1);
                    minLength=right-left;
                }
            }
        if(right<s.length()-1)
            windowing(s,t,left,right+1);
    }
}
