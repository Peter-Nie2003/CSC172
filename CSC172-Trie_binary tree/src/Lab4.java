import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab4 {


    public Lab4(){}
    //method to call the insert() method in Trie class
    public static boolean insert(Trie trie,String x){
        return trie.insert(x);
    }
    //method to call the TrietoList() method in Trie class
    public static void TrietoList(Trie trie){
        trie.TrietoList(trie.getRoot());
    }
    //method to call the largest() method in Trie class
    public static String largest(Trie trie){
        return trie.largest();
    }
    //method to call the smallest() method in Trie class
    public static String smallest(Trie trie){
        return trie.smallest();
    }
    //method to call the search() method in Trie class
    public static String search(Trie trie,String x){
        return trie.search(trie.getRoot(),0,x);
    }
    //method to call the height() method in Trie class
    public static int height(Trie trie){return trie.height(trie.getRoot());}
    //method to call the size() method in Trie class
    public static int size(Trie trie){return trie.size();}

    /*
    Use reader to read each line the file user get.
    call the correct method.
    */
    public static void main(String[] args) throws IOException {
        Trie tester=new Trie();
        String file=args[0];
       BufferedReader reader=new BufferedReader(new FileReader(file));
        String commands;
        while((commands=reader.readLine())!=null){
            String[] Command=commands.split(" ");
            if(Command[0].equals("insert")){
                insert(tester,Command[1]);
            }
            else if(Command[0].equals("search")){
                System.out.println(search(tester,Command[1]));

            }
            else if(Command[0].equals("largest")){
                System.out.println(largest(tester));

            }
            else if(Command[0].equals("smallest")){
                System.out.println(smallest(tester));
            }
            else if(Command[0].equals("height")){
                System.out.println(height(tester));
            }
            else if(Command[0].equals("size")){
                System.out.println(size(tester));
            }
            else{
                tester.getTrieList().clear(); //reset the list every time
                TrietoList(tester);
                for(int i=0;i<tester.getTrieList().size();i++)
                    System.out.print(tester.getTrieList().get(i)+" ");
                    System.out.println();
            }


        }
    }

}
