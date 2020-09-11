package chapter3.section3;



public class RedBlackBST <Key extends  Comparable<Key>,Value> {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key ,Value val ,int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }
    private boolean isRed(Node x){
        if(x == null)
            return  false;
        return x.color == RED;

    }
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) +1 ;
        return x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) +1 ;
        return x;
    }

    private void flipColors(Node h){
        h.right.color = BLACK;
        h.left.color = BLACK;
        h.color = RED;
    }
    public void put (Key key, Value val){
        root = put( root,key, val);
    }
    private Node put(Node h, Key key, Value val){
        if(h == null)
            return new Node(key,val,1,RED);
        int cmp = key.compareTo(h.key);
        if(cmp > 0)
            h.right = put(h.right, key, val);
        else if(cmp < 0 )
            h.left = put(h.left, key, val);
        else
            h.val = val;
        //正常的插入是红链接的节点，然后进行翻转等操作,按照这三步的顺序走可以解决所有情况
        if(isRed(h.right) && !isRed(h.left))
             h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))
             h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))
            flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }

    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x == null)
            return 0;
        else
            return x.N;
    }

}
