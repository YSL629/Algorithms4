package chapter1.section1;

import org.junit.Test;

public class Exercise20 {

    //ln(N!)  乘法分解成加法来做  ln的话用math
    public static double lnFactorial1(int N){
        if(N<1)
            return -1;
        if(N==1)
            return 0;
        return Math.log(N)+lnFactorial1(N-1);
    }

    //乘法累乘
    public static double lnFactorial2(int N){
        if(N<1)
            return -1;
        if(N==1)
            return 1;
        return N*lnFactorial2(N-1);
    }

    @Test
    public void test(){
        for (int i = 1; i <10 ; i++) {
            System.out.println("方法一：ln(" + i +"!)="+lnFactorial1(i));
            System.out.println("方法二：ln(" + i +"!)="+Math.log(lnFactorial2(i)));

        }


    }


}
