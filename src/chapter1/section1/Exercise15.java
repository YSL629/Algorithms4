package chapter1.section1;

import org.junit.Test;

public class Exercise15 {
    public int[] histogram(int []a,int M){
        int []arr = new int[M];
        for (int i = 0; i <a.length ; i++) {
            arr[a[i]]++;
        }
        return arr;
    }

    @Test
    public void test(){

    }
}
