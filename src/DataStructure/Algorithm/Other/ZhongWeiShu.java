package DataStructure.Algorithm.Other;

public class ZhongWeiShu {
    public static int Solution(int[] ints){
        int i = ints.length;
        if(i%2==0){
            return ints[i/2-1];
        }
        else
            return ints[i/2];
    }
    public static int Solution(int[] ints1,int[] ints2){
        int i = ints1.length;
        int j=Solution(ints1);
        int k=Solution(ints2);
        int zhongWei=0;
        if(j==k)
            return j;
        if(i%2==0){
            if(j > k){
                int a=0;int b=i/2-1;
                for(int c=0;c<i/2+1;c++){
                    if(ints1[a]>ints2[b]){
                        zhongWei=ints2[b];
                        b++;
                    }
                    else{
                        zhongWei=ints1[a];
                        a++;
                    }
                }
                return zhongWei;
            }
            else {
                int a=0;int b=i/2-1;
                for(int c=0;c<i/2+1;c++){
                    if(ints2[a]>ints1[b]){
                        zhongWei=ints1[b];
                        b++;
                    }
                    else{
                        zhongWei=ints2[a];
                        a++;
                    }
                }
                return zhongWei;
            }
        }
        if(j > k){
            int a=0;int b=i/2;
            for(int c=0;c<i/2+1;c++){
                if(ints1[a]>ints2[b]){
                    zhongWei=ints2[b];
                    b++;
                }
                else{
                    zhongWei=ints1[a];
                    a++;
                }
            }
            return zhongWei;
        }
        else {
            int a=0;int b=i/2;
            for(int c=0;c<i/2+1;c++){
                if(ints2[a]>ints1[b]){
                    zhongWei=ints1[b];
                    b++;
                }
                else{
                    zhongWei=ints2[a];
                    a++;
                }
            }
            return zhongWei;
        }
    }
}
