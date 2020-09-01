package chapter2.section4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int N = a.length-1;
        for (int k = N / 2; k > 0; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);

        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sink(Comparable[] a, int pos, int last) {
        while (pos * 2 <= last) {
            int j = pos * 2;
            if (j < last && less(a, j, j + 1)) j++;
            if (!less(a, pos, j)) break;
            exch(a, pos, j);
            pos = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
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
        String[] strArray = new String[arrayList.size()+1];
        for (int i = 0; i < arrayList.size(); i++) {
            strArray[i+1] = arrayList.get(i);
        }
        sort(strArray);
        System.out.println(Arrays.toString(strArray));
    }
}
