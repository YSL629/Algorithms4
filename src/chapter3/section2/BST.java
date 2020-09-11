package chapter3.section2;



import java.util.Scanner;
//二叉树查找，递归实现版本
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
        }
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

    public Value get(Key key) {
        return get(root,key);
    }
    private Value get(Node x,Key key){
        //如果查找不到
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            return  get(x.right,key);
        else if(cmp < 0 )
            return  get(x.left,key);
        else
            return x.val;
    }

    public void put(Key key,Value value){
        root = put(root, key, value);
    }

    /*  这里注意put需要有返回值，因为插入结点的过程中对于引用赋值是无法传递到外部的，
        这是java core 前面提出过的一个问题，引用参数实际上是复制了一份引用，可以修改内容，
        但本质上是两个不同的引用，对引用直接赋值时不会改变另外一个引用的指向
    */
    /*
        这里的思想是，对于当前的结点进行put操作，如果当前结点不是null，就返回本身，因为
        如果当前结点是null就把插入的结点返回，实际上插入新结点的操作一定是在遇到空值的时候发生的
        其他的两个状况不需要对结点进行替换，更新结点也只需要更新值就行。
    */
    private Node put(Node x, Key key, Value value){
        if( x == null)
            return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            x.right = put(x.right,key,value);
        else if(cmp < 0)
            x.left =  put(x.left,key,value);
        else
            x.val = value;
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public Key min(){
        if(root == null)
            return null;
        return min(root).key;
    }
    private Node min(Node x)
    {
        if(x.left == null)
            return x;
        return min(x.left);
    }

    public Key max(){
        if(root == null)
            return null;
        return max(root.right).key;
    }
    private Node max(Node x){
        if(x.right == null)
            return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if(x == null)
            return null;
        return x.key;
    }
    private Node floor(Node x,Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp < 0)
            return floor(x.left,key);
        Node t  = floor(x.right,key);
        if(t == null)
            return x;
        else
            return t;
    }

    public Key ceiling(Key key){
        Node x  = ceiling(root,key);
        if(x == null)
            return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp > 0)
            return ceiling(x.right,key);
        Node t = ceiling(x.left,key);
        if(t == null)
            return x;
        else
            return t;
    }
    //查找排名为k键，排名k就是有k个小于它的键(从0开始)
    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x, int k){
        if(x == null)
            return null;
        int t = size(x.left);
        if(t > k)//左侧起码有k+1个键
            return select(x.left,k);
        else if(t == k)
            return x;
        else
            //左子树和x节点一共t+1个键，找k排名等价于在右子树找k-t-1排名的键
            return select(x.right,k-t-1);
    }

    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node x, Key key){
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)
            //总排名等于右子树排名加上左子树数量+1(结点x)
            return rank(x.right,key) + size(x.left) + 1;
        else if(cmp == 0)
            return size(x.left);
        else
            return rank(x.left,key);
    }

    //涉及到改变树的结构的操作基本上是要返回引用的，或者说在函数内部对引用参数进行赋值改变引用值是没用的，需要外部返回
    public void deleteMin(){
        if (root == null)
            return;
        root = deleteMin(root);
    }
    //书本260页图很重要
    private Node deleteMin(Node x){
        if(x.left == null)
            return x.right;

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right)+1; //这里x.N--就行
        return x;
    }

    public void deleteMax(){
        if(root == null)
            return;
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if(x.right == null)
            return x.left;

        x.right = deleteMin(x.right);
        x.N = size(x.left) + size(x.right)+1; //这里x.N--就行
        return x;
    }

    public void delete(Key key){

        root = delete(root,key);
    }
    private Node delete(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            if(x.left == null)
                return null;

        }
        if(cmp > 0 )
            return null;
        if(cmp <0 )
            return null;
        return null;

    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        while(true){
            System.out.println("执行的操作");
            String opt = scanner.nextLine();

        }
    }


}
