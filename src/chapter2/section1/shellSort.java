package chapter2.section1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class shellSort {


    public  static  void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;//step h—sort的间隔这个是较好的间隔用法
        while(h >= 1){
            for(int i = h; i<N; i++){
                for(int j = i; j>=h && less(a[j],a[j-h]); j=j-h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
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
