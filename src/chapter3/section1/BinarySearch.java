package chapter3.section1;



public class BinarySearch {

    public static int search(Comparable[] a, Comparable key){
        int N = a.length;
        int lo = 0;
        int hi = N-1;
        while (lo <= hi){
            System.out.println("("+lo+","+hi +")");
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(a[mid]);
            if(cmp < 0)
                hi = mid-1;
            else if(cmp > 0)
                lo = mid+1;
            else
                return mid;
        }
        System.out.println("没有找到");
        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[20];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }
        System.out.println("搜索结果:"+ search(arr,2));

    }
}
