package chapter3.section1;

import org.w3c.dom.Node;

import java.util.Scanner;

public class BST<Key extends Comparable<Key>,Value>
{
    private Node root;
    private class Node
    {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;
    }


}
