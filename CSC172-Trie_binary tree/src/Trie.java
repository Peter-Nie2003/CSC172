import java.util.ArrayList;

public class Trie {
    private int size; //size of Trie
    private TrieNode root;  //root node
    private ArrayList<String> TrieList=new ArrayList<>(); //List store the String in the node
    private String largest; //largest String in the node
    private String smallest; //smallest String in the node
    public Trie(){size=0;root=null;}  //constructor
    public TrieNode getRoot(){return root;}  //getter method get the root
    //getter method get the list
    public ArrayList<String> getTrieList() {
        return TrieList;
    }
    //insert method: insert the String in correct position in the Trie
    public boolean insert(String x){
        //the situation no node in the Trie
        if(size==0) {
            root=new TrieNode(x);
            root.setHeight(1);
            size++;
            smallest=x;largest=x;//set the largest and smallest
        }
        else{
            TrieNode temp=inserthelp1(root,x,0);//find the correct space in the Trie
            if (temp.getStr().equals("")){ //situation is empty, just set the String in the node.
                inserthelp1(root,x,0).setStr(x);
                if(x.compareTo(smallest)<0) smallest=x;//refresh the largest and smallest
                if(x.compareTo(largest)>0) largest=x;
                size++;//add size
            }
            else if(temp.getStr().equals(x)) {return false;}//situation we already add the same String
            else{
                //situation the appropriate position have a String, we need to compare them and create new node for both of them
            int tracker=temp.getheight()-1;
            inserthelp2(inserthelp1(root,x,0),x,tracker,inserthelp1(root,x,0).getStr());
                if(x.compareTo(smallest)<0) smallest=x;
                if(x.compareTo(largest)>0) largest=x;
            size++;}
        }
        return true;
    }
    //set the String in the Trie to the List in increasing order
    //use recursion go left first then go right
    //if the node is leaf node, append the String in that node into the List
    public void TrietoList(TrieNode rt){
        if(rt.isLeaf()){
            TrieList.add(rt.getStr());
        }
        if(rt.getleft()!=null){
        TrietoList(rt.getleft());}
        if(rt.getright()!=null){
        TrietoList(rt.getright());}

    }
    //return the largest String
    public String largest(){
        return largest;
    }
    //return the smallest String
    public String smallest(){
        return smallest;
    }
    public int size(){return size;}//return the size of Trie
    //use the String in the parameter to travel the Trie
    //if can get to a leaf node, just return the String in the node
    //other situation is, if it can not go to left in a node when the String tell that u should go left, we need to find the most leaf node in that subtree
    //if it can not go to right in a node when the String tell that u should go right, we need to find the most leaf node in that subtree
    public String search(TrieNode rt,int count,String x){
        if(rt.isLeaf()) return rt.getStr();
        String a=x.substring(count,count+1);
        if(a.equals("0")){
            if(rt.getleft()!=null){
                return search(rt.getleft(),count+1,x);
            }
            else return searchhelp1(rt).getStr();
        }
        else{
            if(rt.getright()!=null){
                return search(rt.getright(),count+1,x);
            }
            else return searchhelp2(rt).getStr();
        }

        }
        //recursion function, in the leaf we return 1. each time add 1
    //compare and return the bigger one
    public int height(TrieNode rt){
        if(rt==null) return 0;
        if(rt.isLeaf()) return 1;
        int a=0;
        int b=0;
        if(rt.getleft()!=null){a=height(rt.getleft())+1;}
        if(rt.getright()!=null){b=height(rt.getright())+1;}
        if(a>b) return a;
        else return b;
    }

    //search helping method, find the most left leaf node
    public TrieNode searchhelp1(TrieNode rt){
        if(rt.isLeaf()) return rt;
        if(rt.getleft()!=null) return searchhelp1(rt.getleft());
        else return searchhelp1(rt.getright());
    }
    //search helping method, find the most right leaf node
    public TrieNode searchhelp2(TrieNode rt){
        if(rt.isLeaf()) return rt;
        if(rt.getright()!=null) return searchhelp2(rt.getright());
        else return searchhelp2(rt.getleft());
    }
    //insert helping method, find the correct position for the String in the node already exist
    public TrieNode inserthelp1(TrieNode rt,String element,int count){
        if (rt.isLeaf()){
            return rt;
        }

            String b = element.substring(count,count+1);
            if(b.equals("0")){
                if(rt.getleft()!=null) return inserthelp1(rt.getleft(),element,count+1);
                else {rt.setLeft(new TrieNode(rt.getheight()+1));
                return rt.getleft();}
            }
            else{
                if(rt.getright()!=null) return inserthelp1(rt.getright(),element,count+1);
                else {rt.setRight((new TrieNode(rt.getheight()+1)));
                    return rt.getright();}
            }

    }
 //insert helping method,using when the two String overlap in a same node in the Trie
    //compare the two String and create new TrieNode base the String
    public void inserthelp2(TrieNode node,String element,int count,String c){
        String a=c.substring(count,count+1);
        String b=element.substring(count,count+1);
        if(a.equals("0")&&b.equals("0")) {
            node.setLeft(new TrieNode());
            node.getleft().setHeight(node.getheight()+1);
            inserthelp2(node.getleft(),element,count+1,c);
        }
        else if(a.equals("1")&&b.equals("1")) {
            node.setRight(new TrieNode());
            node.getright().setHeight(node.getheight()+1);
            inserthelp2(node.getright(),element,count+1,c);
        }
        else if(a.equals("0")&&b.equals("1")){
            node.setLeft(new TrieNode());
            node.getleft().setStr(c);
            node.getleft().setHeight(node.getheight()+1);
            node.setRight(new TrieNode());
            node.getright().setStr(element);
            node.getright().setHeight(node.getheight()+1);

        }
        else{
            node.setLeft(new TrieNode());
            node.getleft().setStr(element);
            node.getleft().setHeight(node.getheight()+1);
            node.setRight(new TrieNode());
            node.getright().setStr(c);
            node.getright().setHeight(node.getheight()+1);

        }
        node.clear();
    }

}

