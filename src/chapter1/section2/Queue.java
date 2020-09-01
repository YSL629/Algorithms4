package chapter1.section2;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>  {

    private Node first;
    private Node last;
    private int N;

    private class Node{ //Node是内部类，没法暴露在外部
        T item;
        Node next;
    }

    private class ListIterator implements Iterator<T>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public void reverse(){

          Node pre = null;//用于记录前一项

          while(first != null) {
              Node later = first.next;//记录后一项
              first.next = pre;
              pre = first;
              first = later;
          }
          first = pre;
    }
    public void  enqueue (T item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty())
            first = last;  //加第一个元素要把first安排好了
        else
            oldLast.next = last;
        N++;

    }

    public T dequeue(){
        T item = first.item;  //需要抛出异常，如果在空的时候进行dequeue
        first = first.next;
        if(isEmpty())
            last = null;     //last置null
        N--;
        return item;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("我");
        queue.enqueue("是");
        queue.enqueue("猪");
        queue.enqueue("头"); 
        queue.reverse();
        for (String item :queue) {
            System.out.println(item);
        }

    }
}
