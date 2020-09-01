package chapter1.section1;

public class Exercise29 {
    public static int rank(int key,int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            if(arr[mid] < key)
                lo = mid+1;
            else if(arr[mid]>key)
                hi = mid-1;
            else{
                while(mid>=1 && arr[mid] == arr[mid-1]){//写代码要小心数组越界的问题
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }
    public static int count(int key,int[] arr){
        int count = 1;
       int rank = rank(key,arr);
       if(rank == -1)
           return 0;
       while(rank < arr.length-1 && arr[rank] == arr[++rank]){
           count++;

       }
       return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,2,3,3,3,3,4,4,5,6,6,6,7,7};
        for (int i = 0; i <8 ; i++) {
            System.out.println("index:"+rank(i,a)+" count:"+ count(i,a));
        }
    }

}
