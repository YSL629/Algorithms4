package chapter1.section2;

import java.util.Iterator;
import java.util.Scanner;


//stack linkedlist
public class Stack<T> implements Iterable<T> {

    private Node first; //top of stack
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class Node{
        T item;
        Node next;
    }

   private class ListIterator implements Iterator{
        private Node current = first;
       @Override
       public boolean hasNext() {
           return current!=null;
       }

       @Override
       public T next(){
            T item = current.item;
            current = current.next;
            return item;
       }
   }
   public int size(){
        return N;
   }
   public boolean isEmpty(){
        return N==0;
   }

    public void push(T item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public T pop(){
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args)
    { // Create a stack and push/pop strings as directed on StdIn.
        Stack<String> s = new Stack<>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext())
        {
            String item = scan.next();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                System.out.print(s.pop() + " ");
        }
        System.out.println("(" + s.size() + " left on stack)");
    }
}
