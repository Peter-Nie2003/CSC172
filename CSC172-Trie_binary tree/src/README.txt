Peter Nie
email:jnie7@u.rochester.edu

TrieNode.java:
    *A class of the node in the trie.
    *each node store the height,String,leftchild,rightchild
    *the class include the constructor method,getter method and setter method
    *isLeaf() method check the node is leaf or not.
Trie.java
    *A class of the Trie
    *in the Trie we store the size,smallest and largest String,the root node and the List store the String
    *Also include the constructor method,getter method and setter method.
    *insert():insert the String in correct position in the Trie.
    *TrietoList():set the String in the Trie to the List in increasing order
                  use recursion go left first then go right
                  if the node is leaf node, append the String in that node into the List
    *largest(),smallest(),size() return the largest String,smallest String,size of Trie.
    *search():use the String in the parameter to travel the Trie
                  if can get to a leaf node, just return the String in the node
                  other situation is, if it can not go to left in a node when the String tell that u should go left, we need to find the most leaf node in that subtree
                  if it can not go to right in a node when the String tell that u should go right, we need to find the most leaf node in that subtree
    *height(): recursion function, in the leaf we return 1. each time add 1
               compare and return the bigger one
    *searchhelp1():search helping method, find the most left leaf node
    *searchhelp2():search helping method, find the most right leaf node
    *inserthelp1():insert helping method, find the correct position for the String in the node already exist
    *inserthelp2():insert helping method,using when the two String overlap in a same node in the Trie
                  compare the two String and create new TrieNode base the String

    Lab4.java:
            *insert():method to call the insert() method in Trie class
            *TrietoList():method to call the largest() method in Trie class
            *largest():method to call the largest() method in Trie class
            *smallest():method to call the smallest() method in Trie class
            *size():method to call the size() method in Trie class
            *height():method to call the height() method in Trie class
            *search():method to call the search() method in Trie class
            *main(): use the bufferedreader to read the file that user give.
                    create a new Trie.
                    use split method to store them in each part into an array.
                    check the first element in the array and call the appropriate method
                    sometimes we need to use the second element in the array as a parameter, for example the search and insert method.


    How it works:1. use javac to compile all the java file appear above.
                 2. use java to run it. make sure the commands file in same folder with the java file.