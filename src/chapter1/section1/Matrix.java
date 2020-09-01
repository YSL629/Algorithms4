package chapter1.section1;

import org.junit.Test;

import java.util.Arrays;

public class Matrix {

    public static double dot (double[] x,double[] y){
        if(x.length != y.length)
            throw new RuntimeException("向量长度不匹配");
        double result = 0;
        for (int i = 0; i < x.length ; i++) {
            result += x[i]*y[i];
        }
        return result;
    }

    public static double[][] mult(double[][] a,double[][] b){
        if(a.length != b[0].length || a[0].length != b.length)
            throw new RuntimeException("矩阵不匹配");
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i <a.length ; i++) {
            result[i] = mult(a[i],b);
        }
        return result;
    }

    public static double[][] transpose(double[][] a){
        double[][] trans = new double[a[0].length][a.length];
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[i].length ; j++) {
                trans[j][i] = a[i][j];
            }
        }
        return trans;
    }

    public static double[] mult(double[][] a,double[] x){
        if(x.length != a[0].length)
            throw new RuntimeException("矩阵和向量长度不匹配");
        double[] result = new double[a.length];
        for (int i = 0; i <result.length ; i++) {
            result[i] = dot(a[i],x);
        }
        return result;
    }

    public static double[] mult(double[] x,double[][] a){
        if(x.length != a.length)
            throw new RuntimeException("矩阵和向量的长度不匹配");
        double[] result = new double[a[0].length];
        for (int i = 0; i <result.length ; i++) {
            double element = 0;
            for (int j = 0; j <x.length ; j++) {
                element += x[j]*a[j][i];
            }
            result[i] = element;
        }
        return result;
    }

    @Test
    public void test1(){
        double[] x = {1,0,-1};
        double[] y = {1,0,-1};
        double[][]a ={{1,2,3},{2,3,4},{3,4,5}};
        double[][]b ={{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(dot(x,y));
        System.out.println(Arrays.toString(mult(x,a)));
        System.out.println(Arrays.toString(mult(a,x)));
        System.out.println(Arrays.deepToString(mult(a,b)));
    }
}
