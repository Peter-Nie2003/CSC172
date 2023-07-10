
// implements hash table with linear probing

import java.io.*;
import java.util.Scanner;

class DataItem

{
    private int iData; // data item (key)

    public DataItem(int ii) // constructor

    {
       iData=ii;
    }

    public int getKey()	// getter
    {
       return iData;
    }

} // end class DataItem

class HashTable
{

    private DataItem[] hashArray; // array holds hash table
    private int arraySize;


    public HashTable() // constructor

    {
        hashArray=new DataItem[17]; //set the array
        arraySize=17; //set the size
    }
    //two getter method
    public int getSize(){return arraySize;}
    public DataItem[] getHashArray(){return hashArray;}

    //iterate the hashArray and print it out
    public void displayTable()	// displays hash table
    {
        System.out.print("Table ");
        for(int x=0;x<arraySize;x++){
            if(hashArray[x]==null) System.out.print("** ");
            else System.out.print(hashArray[x].getKey()+" ");
        }
        System.out.println();
    }

    public int hashFunc(int key)	// hash function
    {
        if(key<0) return Math.abs(key)%arraySize;// when the key is negative, set it positive
        else return key%arraySize;
    }

    public void insert(DataItem item) // insert a DataItem
    {
       int i=0;int j;
       while(i<arraySize){
           j=hashFunc(item.getKey()+i);
           if(hashArray[j]==null){
               hashArray[j]=item;
               break;
           }
           else if(hashArray[j].getKey()==item.getKey()){
               return;
           }
           else i++;
       }

    } // end insert()


    public DataItem delete(int key) // delete a DataItem
    {
        int i=0;int j;
        while(i<arraySize){
            j=hashFunc(key+i);
           if(hashArray[j]==null) break;
           else if(hashArray[j].getKey()==key) {DataItem x=hashArray[j]; hashArray[j]=null;return x;}
           else i++;
        }
        return null;
    } // end delete()


    public DataItem find(int key) // find item with key
    {
        int i=0;int j;
        while(i<arraySize){
            j=hashFunc(key+i);

            if(hashArray[j]==null) break;
            else if(hashArray[j].getKey()==key) return hashArray[j];
            else i++;
        }
        return null;

    }
    public void rehash(){
        int prime = 0;
       int x=2*arraySize;//double the size of array first
       while(true){
           if(isPrime(x)==true) {prime=x;break;}//find the prime
           else  x++;
       }
       arraySize=prime;//enlarge the array
        DataItem[] new_hashArray=new DataItem[arraySize];
        //put the item from old hashArray to the new one
        for(int i=0;i< hashArray.length;i++){
            if(hashArray[i]!=null){
                int j=0;int k;
                while(j<arraySize){
                k=hashFunc(hashArray[i].getKey()+j);
                if(new_hashArray[k]==null){
                    new_hashArray[k]=hashArray[i];
                    break;
                }
                else{j++;}
                }
            }
        }
        hashArray=new_hashArray;

    }
    //method to find a prime
   public  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }


} // end class HashTable

class HashTableApp
{
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        Scanner x=new Scanner(System.in);
        HashTable table=new HashTable();
         while(true) // interact with user
        {

            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            // add code for reading choice

            String a=x.next();
            if(a.equals("quit")) break;//enter "quit" can quit the program
            Character choice=a.charAt(0);


           switch(choice)
            {
                case 's':
                   table.displayTable();
                    break;

                case 'i':
                    System.out.print("Enter key value to insert: ");
                    int key1=x.nextInt();
                    aDataItem=new DataItem(key1);
                    table.insert(aDataItem);
                    break;

                case 'd':
                    System.out.print("Enter key value to delete: ");
                    int key2=x.nextInt();
                    table.delete(key2);
                    break;

                case 'f':
                    System.out.print("Enter key value to find: ");
                   int key3=x.nextInt();
                   if(table.find(key3)==null){System.out.println("The key value is not in the HashTable"); }
                   else System.out.println("Found "+table.find(key3).getKey());
                    break;


                default:
                    System.out.print("Invalid entry\n");

            } // end switch
            //check the number of item in the array every while loop. if load factor over 0.75 call rehash() method.
            int num=0;DataItem[] temp= table.getHashArray();
           for(int i=0;i<table.getSize();i++){
             if(temp[i]!=null) num++;
           }
           if((double)num/table.getSize()>=0.75){
               table.rehash();
           }


        } // end while

    } // end main()


} // end class HashTableApp