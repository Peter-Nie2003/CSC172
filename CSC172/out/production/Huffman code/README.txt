Peter Nie
email:jnie7@u.rochester.edu
CSC172-Project2
Extra files:
       *BinaryIn.java
       *BinaryOut.java
       *Huffman.java

HuffmanSubmit.java:

    ArrayList<HuffmanNode> PriQue:an arraylist to store the HuffmanNode

    HashMap<String,HuffmanNode> Hufholder:the HashMap, the key is the binary number and value is HuffmanNode

    HuffmanNodeComparator comparator:create the arraylist comparator

    HuffmanNode root:initiate the root of the tree

   class HuffmanNodeComparator: Comparator class to help sort the arraylist correctly.

   class HuffmanNode: A HuffmanNode class. include the binary number, frequency,Huffman Code, left child,right child.
                HuffmanNode(): Constructor for no parameter.
                HuffmanNode(String binary):Constructor for the parameter is binary number.
                HuffmanNode(String binary,int frq):Constructor for the parameters are binary number and the frequency.
                addFrq():method to add the frequency.

  readString(String inputFile):
            *read the input
            *every 8 times we put create check the HashMap,
            *if there is the same key (binary number) we just add frequency.
            *else we create a new HuffmanNode and set the frq 1, then add into the HashMap.

  writeFrefile(String freqFile):
            *use writer to write the every element in arraylist to a txt file.

  convertToPriQue():
            *Use for loop to put every element in the HashMap to the arraylist and sort the arraylist.

   createTree():
            *We just pick the first two out.
            *And create a new HuffmanNode, which the frequency equal the sum of the first two node.
            *left child is first one,right child is second on. Then the new HuffmanNode become the root.
            *Put the new HuffmanNode back to the arraylist and sort the arraylist.
            * continue do this action While there is more than 1 element in the arraylist.

   setHufCode(HuffmanNode root,String x):
            *traverse the tree from root, When the node is not a leaf
            *Use a String to keep the way we go. go left we add"0",right we add"1".
            * if the current node is a leaf, set the code of the node equal to the String and return.
            *Also we print out the Huffman code use for loop and a variable cnt to track the level of depth.
            *If there is leaf we print it print the Huffman code and binary number together.
            *We print the tree in Pre-order traversal.

   writeErcFile(String inputFile,String outputFile):
            *Use the samie logic with the readString() method.
            *Every 8 times, we use the binary number we read  as a key to find the Huffman code from HashMap.
            *Use writer to write in the file and use flush() to print them all out.

   readFreqFile(String freqFile):
            *Use reader to get every lines from the frequency table file.
            *use the regex to seperate each line.
            *the last index in the String is frq.
            *the first 8 index is the binary number.
            *create a new HuffmanNode,put into the arraylist and sort it.

   Depress(String inputFile, String outputFile):
            *read the input file.
            *if the input is true, current node go to right else go to left.
            *if the current node is a leaf.
            *get the binary number and write it out.

   encode(String inputFile, String outputFile, String freqFile):
            *everytimes we need to reset arraylist, HashMap and the root node
            *read the inputFIle.
            *create the arraylist.
            *write the frequency table.
            *create the tree.
            *set the Huffman code.
            *write the compress file.

   decode(String inputFile, String outputFile, String freqFile):
            *everytimes we need to reset arraylist, HashMap and the root node
            *read the inputfile.
            *create the arraylist.
            *create the tree and set the Huffman code.
            *write the depress file.