package chapter1.section1;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise28 {

    public static int[] removeDuplicate(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i] != arr[i+1]){
                arrayList.add(arr[i]);
            }
        }
        arrayList.add(arr[arr.length-1]);
        int [] removeDup = new int[arrayList.size()];
        for (int i = 0; i <removeDup.length ; i++) {
            removeDup[i] = arrayList.get(i);
        }
        return  removeDup;
    }

    public static void main(String[] args) {
        int[] whiteList ={1,4,7,6,5,5,3,2,1,4,6,3,5,7,4,3,2,2};
        int[] whiteListDest = removeDuplicate(whiteList);
        System.out.println(Arrays.toString(whiteListDest));
    }
}
