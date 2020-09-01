package chapter1.section1;

import org.junit.Test;

public class    Exercise22 {
    public static int rank(int[] arr,int key,int lo,int hi,int depth){
        if(lo>hi)
            return -1;
        int mid = lo + (hi-lo)/2;
        for (int i = 0; i <depth ; i++) {
            System.out.print(" ");
        }
        System.out.println("("+lo+","+hi+")");


        if(arr[mid]<key)
            return rank(arr,key,mid+1,hi,++depth);
        else if(arr[mid]>key)
            return rank(arr,key,lo,mid-1,++depth);
        else {
            System.out.println("查找结果：index=" + mid);
            return mid;
        }
    }
    public static int rank(int[] arr,int key){
        return rank(arr,key,0,arr.length-1,0);
    }
    @Test
    public void test(){
        int[] arr = new int[100];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= i;
        }
        rank(arr,22);
    }
}
