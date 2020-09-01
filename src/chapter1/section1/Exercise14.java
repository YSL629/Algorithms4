package chapter1.section1;

import org.junit.Test;

public class Exercise14 {
    public static int lg(int N){
       int ex = 0;
        while(N>1){
           N>>=1;//右移
           ex++;
       }
       return ex;
    }

    @Test
    public void test(){
        System.out.println(lg(8));
    }
}
