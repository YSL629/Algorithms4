package chapter2.section3;

import StdLib.StdRandom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void sort(Comparable[] a){
        //打乱
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[]a, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static int partition(Comparable[]a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);                                      ;
        }
        exch(a,lo,j);
        return j;
    }
    public  static  void  sort3way(Comparable[]a, int lo, int hi){
        if(hi<=lo)
            return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0) exch(a,i++,lt++);
            else if(cmp > 0) exch(a,i,gt--);
            else i++;
        }
        sort3way(a,lo,lt-1);
        sort3way(a,gt+1,hi);
    }
    public  static  void  sort3way(Comparable[]a){
        int N = a.length;
        sort3way(a,0,N-1);
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
        sort3way(strArray);
        assert isSorted(strArray);
        System.out.println(Arrays.toString(strArray));
    }

}
