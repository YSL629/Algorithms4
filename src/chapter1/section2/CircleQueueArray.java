package chapter1.section2;


import java.util.Iterator;
import java.util.Scanner;

public class CircleQueueArray<T> implements Iterable<T> {

    private T[] a;
    private int capacity ;
    private int front = 0;
    private int rear = 0;
    public CircleQueueArray(int capacity){
        a = (T[]) new Object[capacity];
        this.capacity = capacity;
    }
    public void enqueue(T item){
        //判断有没有满
        if((rear+1)%capacity == front) {
            System.out.println("队列已满");
            return;
        }
        a[rear] = item;
        rear = (rear+1)%capacity;
    }
    public T dequeue(){
        if(rear == front){
            System.out.println("队列为空");
            return null;
        }
        T temp =  a[front];
        front = (front+1)%capacity;
        return temp;

    }
    @Override
    public Iterator<T> iterator() {
        return new QueueArrayIterator();
    }
    private class QueueArrayIterator implements Iterator<T> {
        private int current = front;
        @Override
        public boolean hasNext() {
            return (current != rear);
        }
        @Override
        public T next() {
            T temp = a[current];
            current = (current+1)%capacity;
            return temp;
        }
    }

    public static void main(String[] args) {
        CircleQueueArray<String> queue = new CircleQueueArray<>(5);
        Scanner scan = new Scanner(System.in);
        while(true){
           String str = scan.nextLine();
           if (str.equals("-") )
               queue.dequeue();
           else if(str.equals("exit"))
               break;
           else
               queue.enqueue(str);
           for(String i : queue)
               System.out.println(i);
           System.out.println("-----");
        }


    }
}
