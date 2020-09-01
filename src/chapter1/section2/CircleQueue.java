package chapter1.section2;


import java.util.Iterator;

public class CircleQueue<T> implements Iterable<T> {
    private int N;
    private Node last;


    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T dequeue() {
        T item = last.next.item;
        if (last == last.next)
            last = null;
        else
            last.next = last.next.next;
        N--;
        return item;
    }

    public void enqueue(T item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            last = node;
            node.next = last;
        }
        node.next = last.next;
        last.next = node;
        last = node;
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircleQueueList();
    }

    private class CircleQueueList implements Iterator<T> {
        private Node current = last;
        private int n = N;

        @Override
        public boolean hasNext() {
            return n > 0;//短路的操作
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            n--;
            return item;
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (T item : this) {
            buffer.append(item + " ");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        CircleQueue<String> queue = new CircleQueue<>();
        queue.enqueue("我");
        queue.enqueue("是");
        queue.enqueue("猪");
        queue.enqueue("头");
        queue.dequeue();
        queue.dequeue();


        System.out.println(queue.toString());
    }
}

