package chapter2.section2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeBU {
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        int N = a.length;
        for (int len = 1; len < N ; len+=len) {
            //最后一定要剩比一个len要大的长度才有必要合并
            for(int lo = 0; lo < N-len; lo += len+len){
                merge(a,aux,lo, lo+len-1,Math.min(N-1,lo+len+len-1));
            }

        }
    }

    public static void merge(Comparable a[],Comparable[] aux, int lo, int mid, int hi){

        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k<=hi; k++){
            if(i>mid){
                a[k] = aux[j++];
            }
            else if(j>hi){
                a[k] = aux[i++];
            }
            else if(less(aux[i],aux[j])){
                a[k] = aux[i++];
            }
            else{
                a[k] = aux[j++];
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
