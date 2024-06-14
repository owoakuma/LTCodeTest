package Test;

import java.util.Stack;

/**
 * @author i
 * @create 2020/7/20 18:16
 * @Description
 */
public class Test1 {

    public void reverse(Stack<Integer> stack){
        //如果栈为null 退出
        if (stack.isEmpty()){
            return;
        }
        //将栈底元素拿到
        int i = removeLastElement(stack);
        reverse(stack);
        //存储当前层的i值
        stack.push(i);
    }

    public int removeLastElement(Stack<Integer> stack){
        int res = stack.pop();
        if (stack.isEmpty()){
            return res;
        }else {
            //返回的是递归函数的栈底的值
            int last = removeLastElement(stack);
            //存储当前层的res值
            stack.push(res);
            return last;
        }
    }


    public static void main(String[] args) {
        Test1 stackReverse = new Test1();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stackReverse.reverse(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}

