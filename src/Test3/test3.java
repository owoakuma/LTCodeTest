package Test3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test3 {
    public static void main(String[] args) {
        Queue<Integer> trains=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        int[] out={4,2,3,1};
        int[] in={1,2,3,4};
        int pout=0;
        int pin;
        for(pin=0;pin<in.length;pin++){
            if(in[pin]==out[pout]){
                pout++;
                continue;
            }
            stack.push(in[pin]);
        }
        boolean possible=true;
        while (!stack.isEmpty()){
            if(stack.pop()!=out[pout]){
                System.out.println("impossible!");
                possible=false;
                break;
            }
            pout++;
        }
        if(possible){
            System.out.println("possible!");
        }
        for(int i:out){
            trains.add(i);
        }
        int nowRoads=0;
        int[] RoadsNumber=new int[out.length+1];
        Arrays.fill(RoadsNumber,0);
        while(!trains.isEmpty()){
            int i=trains.poll();
            boolean newRoad=true;
            for(int j=0;j<nowRoads;j++){
                if(RoadsNumber[j]==i-1){
                    RoadsNumber[j]=i;
                    newRoad=false;
                    break;
                }
            }
            if(newRoad){
                RoadsNumber[nowRoads]=i;
                nowRoads++;
            }
        }
        System.out.println(nowRoads);
    }
}
