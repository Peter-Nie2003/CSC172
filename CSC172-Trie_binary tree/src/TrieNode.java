/*
* The Trie node class*/
public class TrieNode {
    private int height;   //height of node
    private TrieNode left;  //leftchild
    private TrieNode right;  //rightchild
    private String Str;      //String store in the node

    // Three constructor with different parameter to create a new node
    public TrieNode(){height=0;left=null;right=null;Str="";}
    public TrieNode(int height){this.height=height;left=null;right=null;Str="";}
    public TrieNode(String Str){height=0;left=null;right=null;this.Str=Str;}
    //four getter method to get the private variable in the node
    public String getStr(){return Str; }
    public TrieNode getleft(){return left;}
    public TrieNode getright(){return right;}
    public int getheight(){return height;}
    //four setter method to set the private variable in the node
    public void setStr(String element){Str=element;}
    public void setLeft(TrieNode node){left=node;}
    public void setRight(TrieNode node){right=node;}
    public void setHeight(int x){height=x;}
    //method to clear the String store in the node
    public void clear(){Str="";}
    //method check the node is a leaf node or not
    public boolean isLeaf(){
        if(left==null&&right==null) return true;
        else return false;
}}
