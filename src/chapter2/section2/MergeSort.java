package chapter2.section2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//三个改进的方法
/*
1.对于小型数组，使用希尔排序
2.先判断一下是否已经排序完成了
3.递归的代码中，通过传参来防止再次重复的复制
 */
public class MergeSort {
    public static int CUTOFF = 15;

    public static  void sort(Comparable[] src, Comparable[] dest, int lo, int hi){
        if(lo>=hi)
            return;
//        if(hi-lo<CUTOFF){
//            insertionSort(dest,lo,hi);
//            return;
//        }

        int mid = lo + (hi-lo)/2;
        sort(dest,src,lo,mid);
        sort(dest,src,mid+1,hi);
        //src中存了最新的结果，其实就是不断反转结果输出方向的实现
        merge(src,dest,lo,mid,hi);
    }
    public static void sort(Comparable[] a){
        Comparable[] aux = a.clone();
        sort(aux,a,0,a.length-1);
    }

    public static void insertionSort(Comparable[] dest,int lo, int hi){
        int N = dest.length;
        for(int i = lo; i<=hi; i++){
            for(int j = i; j>lo && less(dest[j],dest[j-1]); j--){
                exch(dest,j,j-1);
            }
        }
    }
    public static void merge(Comparable[] src, Comparable[] dest, int lo, int mid , int hi){
       //if ordered

        if(less(src[mid],src[mid+1])){
            for(int i = lo ; i<=hi; i++)
            {
                dest[i] = src[i];
            }
            return;
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k<=hi;k++){
            if(i>mid){
                dest[k] = src[j++];
            }
            else if(j>hi){
                dest[k] = src[i++];
            }
            else if(less(src[i],src[j])){
                dest[k] = src[i++];
            }
            else{
                dest[k] = src[j++];
            }
        }
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    public static void exch(Comparable[]a, int i, int j){
        Comparable temp  = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable a[]){
        for(int i = 0; i < a.length-1; i++){
            if(!less(a[i],a[i+1])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        File file = new File("alphabet.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(inputStream);
        ArrayList<String> arrayList = new ArrayList<>();
        while (scan.hasNext()) {
            String str = scan.next();
            arrayList.add(str);
        }
        String[] strArray = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArray[i] = arrayList.get(i);
        }
        sort(strArray);
        assert isSorted(strArray);
        System.out.println(Arrays.toString(strArray));
    }
}
