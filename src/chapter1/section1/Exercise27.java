package chapter1.section1;
/*
*二项分布的一个递推式  f（N，k）= p*f(N-1,k) + (1-p)*f(N-1,k)
*
*
 */
public class Exercise27 {
    private static int count1;
    private static int count2;
    private static int count3;
    private static double[][] Matrix;//记录重复的数值的

    public static double binomial1(int N, int K,double p){
        count1++;
        if(N == 0 &&  K == 0)
            return 1;
        if(N < 0 || K < 0)
            return 0;
        return p*binomial1(N-1,K-1,p) + (1-p)*binomial1(N-1,K,p);
    }
    //改进之后，就是不要再去算 N<k的部分了

    public static double binomial2(int N, int K,double p){
        count2++;
        if(N<K)
            return 0;
        if(N == 0 &&  K == 0)
            return 1;
        if(N < 0 || K < 0)
            return 0;
        return p*binomial2(N-1,K-1,p) + (1-p)*binomial2(N-1,K,p);

    }
    //改进：用一个二维数组保存概率值，这样的话不用进行重复的运算
    public static double binomial3(int N,int K,double p){
        count3++;
        if(N<K)
            return 0;
        if(N==0 && K==0)
            return 1;
        if(N < 0 || K < 0)
            return 0;
        if(Matrix[N][K] == 0)//没有算过的位置就进行一下计算，如果算过了直接调用
            Matrix[N][K] =  p*binomial3(N-1,K-1,p) + (1-p)*binomial3(N-1,K,p);
        return Matrix[N][K];

    }
    public static double getBinomial3(int N,int K ,double p){
        Matrix = new double[N+1][K+1];
        return binomial3(N,K,p);
    }

    public static void main(String[] args) {

        System.out.println("结果："+binomial1(20,10,0.3)+"次数："+count1);
        System.out.println("结果："+binomial2(20,10,0.3)+"次数："+count2);
        System.out.println("结果："+getBinomial3(100,50,0.3)+"次数："+count3);

    }
}
