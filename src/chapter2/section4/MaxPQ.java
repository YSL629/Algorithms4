package chapter2.section4;

public class MaxPQ<Key extends Comparable<Key>>
{
    private Key pq[];
    private int N = 0;

    public  MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[N++] = v;
        swim(N);
    }

    public Key delMaX(){
        Key max = pq[1];
        pq[1] = pq[N];
        pq[N--] = null;
        sink(1);
        return max;
    }

    public boolean less(int i, int j){
        return  pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j){
        Key v = pq[i];
        pq[i] = pq[j];
        pq[j] = v;
    }

    private void swim(int k){
        while(k>1 && less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    private void sink(int k){
        while(k*2 <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

}
