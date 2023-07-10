// Import any package as required


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HuffmanSubmit implements Huffman {

    //Comparator class to help sort the arraylist correctly.
    public static class HuffmanNodeComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.frq - y.frq;
        }
    }
    public static class HuffmanNode  {
        private String binary;  //Store the binary number.
        private int frq;      //the times that binary number occur

        private HuffmanNode left;   //left child of the tree
        private HuffmanNode right;   //right child of the tree
        private String code;        //Huffman code


        // Constructor for no parameter
        HuffmanNode(){
            code = null;
            binary ="";
            left =null;
            right=null;
            frq = 0;
        }
        //Constructor for the parameter is binary number
        HuffmanNode(String binary){
            this.binary=binary;
            code = null;
            left =null;
            right=null;
            frq = 0;
        }
        //Constructor for the parameters are binary number and the frequency
        HuffmanNode(String binary,int frq){
            this.binary=binary;
            this.frq=frq;
            code = null;
            left =null;
            right=null;
        }
        void addFrq(){
            frq++;
        }  //method to add the frequency.

        
    }



    private ArrayList<HuffmanNode> PriQue = new ArrayList<>();    //an arraylist to store the HuffmanNode
    private HashMap<String,HuffmanNode> Hufholder = new HashMap<>();   //the HashMap, the key is the binary number and value is HuffmanNode
    private HuffmanNodeComparator comparator = new HuffmanNodeComparator();  //create the arraylist comparator
    private HuffmanNode root = null;     //initiate the root of the tree


    private void readString(String inputFile){
        BinaryIn input = new BinaryIn(inputFile);
        StringBuilder String = new StringBuilder(); // store the binary number
        int cnt = 0;  // counter to check the times we read
        while(!input.isEmpty()){
            boolean temp = input.readBoolean();
            if(temp) String.append("1");
            else String.append("0");
            cnt++;
            if(cnt==8){
                /* every 8 times we put create check the HashMap,
                if there is the same key (binary number) we just add frequency.
                else we create a new HuffmanNode and set the frq 1, then add into the HashMap.
                 */
                String ascii = String.toString();
                String =new StringBuilder();
                cnt=0;
                if(Hufholder.containsKey(ascii)){
                    Hufholder.get(ascii).addFrq();
                }
                else{
                    HuffmanNode huffnode = new HuffmanNode(ascii);
                    Hufholder.put(ascii,huffnode);
                    huffnode.addFrq();
                }
            }
        }

    }



    // use writer to write the every element in arraylist to a txt file.
    private void writeFrefile(String freqFile) throws IOException {
        FileWriter writer = new FileWriter(freqFile);
        for(HuffmanNode node:PriQue) {
            writer.write(node.binary + ":" + node.frq + "\n");
        }
        writer.close();
    }
    //Use for loop to put every element in the HashMap to the arraylist and sort the arraylist.
    private void convertToPriQue(){
        for(HuffmanNode node:Hufholder.values()){
            PriQue.add(node);
            PriQue.sort(comparator);
        }
    }
    private void createTree(){
        /*
         We just pick the first two out.
        *And create a new HuffmanNode, which the frequency equal the sum of the first two node.
        *left child is first one,right child is second on. Then the new HuffmanNode become the root.
        *Put the new HuffmanNode back to the arraylist and sort the arraylist.
        * continue do this action While there is more than 1 element in the arraylist
         */

        while(PriQue.size()>1){
            HuffmanNode x = PriQue.get(0);
            PriQue.remove(0);
            HuffmanNode y = PriQue.get(0);
            PriQue.remove(0);
            HuffmanNode f = new HuffmanNode();
            f.frq= x.frq+y.frq;
            f.left=x;
            f.right=y;
            root=f;
            PriQue.add(f);
            Collections.sort(PriQue,comparator);



        }
    }

    /* traverse the tree from root, When the node is not a leaf
        *Use a String to keep the way we go. go left we add"0",right we add"1".
        * if the current node is a leaf, set the code of the node equal to the String and return.
        * print the tree in pre-order traversal.
     */
    private void setHufCode(HuffmanNode root,String x,int cnt){
        for(int i = 0; i < cnt; i++){
            System.out.print("| "); //The number of "|" show the level of the node in
        }
        if(cnt == 0) System.out.println("root");
        else{
             //Print out the Huffman node
            if(root.left==null&&root.right==null){
                System.out.println(x+"\t"+root.binary);//If there is leaf we also print the binary number we get
            }
            else{
                System.out.println(x);
            }

        }
        if(root.left==null&&root.right==null){
            root.code=x;
            return;
        }
        String left = x+"0";
        String right =x+"1";
        setHufCode(root.left,left,cnt+1);//every recursion mean we go 1 depth deeper.
        setHufCode(root.right,right,cnt+1);

    }

    /*
    Use the samie logic with the readString() method.
    Every 8 times, we use the binary number we read  as a key to find the Huffman code from HashMap.
    Use writer to write in the file and use flush() to print them all out.
     */
    private void writeErcFile(String inputFile,String outputFile){
        BinaryIn input = new BinaryIn(inputFile);
        StringBuilder temp = new StringBuilder();
        BinaryOut out = new BinaryOut(outputFile);
        int cnt=0;
        while(!input.isEmpty()){
            Boolean x = input.readBoolean();
            if(x) temp.append("1");
            else temp.append("0");
            cnt++;
            if(cnt==8){
                String ascii = temp.toString();
                temp = new StringBuilder();
                cnt=0;
                String code = Hufholder.get(ascii).code;
                for(int i=0;i<code.length();i++){
                    out.write(code.charAt(i)=='1');
                }
            }

        }
        out.flush();
    }
//Use reader to get every lines from the frequency table file.
    private void readFreqFile(String freqFile){
        BinaryIn input = new BinaryIn(freqFile);
        String[] inputs =input.readString().split("\\r?\\n");//use the regex to seperate each line
        for(String in:inputs){
            int frq = Integer.parseInt(in.substring(9));//the last index in the String is frq
            String binary = in.substring(0,8);// the first 8 index is the binary number
            HuffmanNode node = new HuffmanNode(binary,frq);
            PriQue.add(node);
            PriQue.sort(comparator);
            //create a new HuffmanNode,put into the arraylist and sort it.
        }
    }
//method to depress the file
    private void Depress(String inputFile, String outputFile){
        BinaryIn input = new BinaryIn(inputFile);
        BinaryOut output = new BinaryOut(outputFile);
        HuffmanNode curr = root;   //set a pointer in the root first
        int cnt = 0, total =root.frq;  //the times we have write already and the total times we expect to write
        while(!input.isEmpty() && cnt<total){
            if(curr.left==null && curr.right==null){// if the point is a leaf
                String binary = curr.binary;
                for(int i =0;i<binary.length();i++){
                    output.write(binary.charAt(i)=='1');
                    //print the binary number index by index
                }
                cnt++;//counter add 1
                curr=root; //reset the pointer to the root.
            }
            else{
                boolean x = input.readBoolean(); // read the input file boolean by boolean
                if(x) curr=curr.right;  //if boolean is true which mean is "1",go right
                else curr =curr.left;   //if boolean is false which mean is "0", go left
            }
        }
        output.flush();


    }


    public void encode(String inputFile, String outputFile, String freqFile) throws IOException {
        PriQue.clear();
        Hufholder.clear();
        root = null;
        //reset the HashMap,arraylist,root node every times.
        String x =""; // empty String use in traversal
        readString(inputFile); // read input
        convertToPriQue();  //use HashMap to create arraylist
        writeFrefile(freqFile); //write the frequency table
        createTree(); // create the tree use the arraylist
        setHufCode(root,x,0); //set the Huffman code
        writeErcFile(inputFile,outputFile);  //write the Huffman code into the file
    }


    public void decode(String inputFile, String outputFile, String freqFile){
        PriQue.clear();
        Hufholder.clear();
        root=null;
        //reset the HashMap,arraylist,root node every times.
        String x ="";// empty String use in traversal
        readFreqFile(freqFile);
        createTree();
        //read the frequency table,create the arraylist and create the tree.
        setHufCode(root,x,0);// set the Huffman code
        Depress(inputFile,outputFile); //write the depress file


    }



    public static void main(String[] args) throws Exception {
        Huffman  huffman = new HuffmanSubmit();
        huffman.encode("ur.jpg", "ur.enc", "freq_ur.txt");
        huffman.decode("ur.enc", "ur_enc.jpg", "freq_ur.txt");
        huffman.encode("alice30.txt", "alice30.enc", "freq.txt");
        huffman.decode("alice30.enc", "alice30_dec.txt", "freq.txt");

    }

}
