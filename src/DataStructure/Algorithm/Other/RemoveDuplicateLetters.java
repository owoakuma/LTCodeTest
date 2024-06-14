package DataStructure.Algorithm.Other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> existence = new HashSet<>();
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            letters.put(s.charAt(i), 1 + letters.getOrDefault(s.charAt(i), 0));
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!existence.contains(s.charAt(i))) {
                while (!stack.empty() && stack.peek() > s.charAt(i) && letters.get(stack.peek()) != 0) {
                    existence.remove(stack.pop());
                }
                stack.add(s.charAt(i));
                existence.add(s.charAt(i));
            }
            letters.put(s.charAt(i),letters.get(s.charAt(i))-1);
        }
        char[] chars=new char[existence.size()];
        for(int i=0;i<chars.length;i++){
            chars[i]=stack.pop();
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=chars.length-1;i>=0;i--){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
