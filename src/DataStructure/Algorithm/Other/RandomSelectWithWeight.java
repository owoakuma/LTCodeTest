package DataStructure.Algorithm.Other;

public class RandomSelectWithWeight {
    int sum=0;
    int[] v;
    public RandomSelectWithWeight(int[] w) {
        v=new int[w.length];
        for(int i=0;i<w.length;i++){
            v[i]=sum+w[i];
            sum+=w[i];
        }
    }
    public int pickIndex() {

        return 0;
    }
}
