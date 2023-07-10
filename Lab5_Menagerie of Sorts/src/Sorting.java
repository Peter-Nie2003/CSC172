/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms.
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Sorting {

    public static void defaultSort(int[]a){
        Arrays.sort(a);
    }

    public static void bubbleSort(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++){
            int swap =0;
            for(int j=n-1;j>i;j--){
                if(a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    swap++;
                }
            }
            if(swap==0) break;
        }
    }

    public static void selectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]) min=j;
            }
            int temp=a[min];
            a[min]=a[i];
            a[i]=temp;
        }
    }

    public static void insertionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++){

            for(int j=i;j>0&&a[j]<a[j-1];j--){
                int temp = a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
            }
        }
    }

    public static void mergeSort(int[] a){
        int n=a.length;
        if(n<2) return;
        int mid=n/2;
        int[] left =new int[mid];
        int[] right=new int[n-mid];
        for(int i=0;i<mid;i++){
            left[i]=a[i];
        }
        for(int i=mid;i<n;i++){
            right[i-mid]=a[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(a,left,right,mid,n-mid);


    }

    public static void merge(int[] a,int[] left,int[] right,int l,int r){
        int i=0,j=0,k=0;
        while(i<l&&j<r){
            if(left[i]<right[j]) a[k++]=left[i++];
            else a[k++] =right[j++];
        }
        while(i<l) a[k++]=left[i++];
        while(j<r) a[k++]=right[j++];

    }
    public static void quickSort(int[] a){
        int n=a.length-1;
        qsort(a,0,n);
    }
    public static void qsort(int[] a, int i, int j) {      // Quicksort
        int pivotindex = findpivot(a, i, j); // Pick a pivot
        int temp1=a[pivotindex];
        a[pivotindex]=a[j];
        a[j]=temp1;// Stick pivot at end
        // k will be the first position in the right subarray
        int k = partition(a, i-1, j, a[j]);
        int temp2=a[k];
        a[k]=a[j];
        a[j]=temp2;// Put pivot in place
        if ((k-i) > 1) qsort(a, i, k-1);   // Sort left partition
        if ((j-k) > 1) qsort(a, k+1, j);   // Sort right partition
    }
   public static int partition(int[] a, int l, int r, int pivot) {
        do {                 // Move bounds inward until they meet
            while (a[++l]<pivot);
            while ((r!=0) && (a[--r]>pivot));
                int temp=a[l];
                a[l]=a[r];
                a[r]=temp;

            // Swap out-of-place values
        } while (l < r);
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
        // Reverse last, wasted swap
        return l;      // Return first position in right partition
    }


    public static int findpivot(int[] a, int i, int j)
    { return (i+j)/2; }

    public static void writeFile(int[]arr,String a) throws IOException {
        String Fullname=a+".txt";
        FileWriter writer=new FileWriter(Fullname);
        for(int i=0;i<arr.length;i++){
            writer.write(arr[i]+"\n");
        }
        writer.close();

    }
    public static void sortDirector(String sortNum,int[] arr,String arr_name,String file_name) throws IOException {
       String algorithmUsed = "";
       Stopwatch timer = new Stopwatch();
        switch (sortNum){
            case "0": {defaultSort(arr);break;}
            case "1": {bubbleSort(arr);break;}
            case "2": {selectionSort(arr);break;}
            case "3": {insertionSort(arr);break;}
            case "4": {mergeSort(arr);break;}
            case "5": {quickSort(arr);break;}
        }
        double time = timer.elapsedTimeMillis();
        switch (sortNum){
            case "0": algorithmUsed+="Arrays.sort()";break;
            case "1": algorithmUsed+="Bubble Sort";break;
            case "2": algorithmUsed+="Selection Sort";break;
            case "3": algorithmUsed+="Insertion Sort";break;
            case "4": algorithmUsed+="Mergesort";break;
            case "5": algorithmUsed+="Quicksort";break;
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String netID = "jnie7";
        String arrayUsed = arr_name;
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, file_name);
        writeFile(arr,arr_name);
    }

    /**
     *
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort
     * 3 = Insertion Sort
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IOException {
        In in = new In(args[0]);

       //Storing file input in an array
        int[] a = in.readAllInts();


        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        // c contains all integers stored in reverse order
        // (you can have your own O(n) solution to get c from b
        // d contains almost sorted array
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.
        int[] b =new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i] =a[i];
        }
        Arrays.sort(b);
        int[] c=new int[a.length];
        int j=b.length-1;
        for(int i=0;i<a.length;i++){
            c[j]=b[i];
            j--;
        }
        int d[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            d[i] =b[i];
        }

        for(int i=0;i<a.length*0.1;i++){
            int random1=StdRandom.uniform(a.length);
            int random2=StdRandom.uniform(a.length);
            while(random1==random2){random1=StdRandom.uniform(a.length);}
            int temp = d[random1];
            d[random1]=d[random2];
            d[random2]=temp;

        }
        //TODO:
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort
        //  * 3 = Insertion Sort
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those.
        // For runtime and priting, you can use the same code from Lab 4 as follows:
        // TODO: For each array, a, b, c, d:
        // TODO: Perform Sorting and store the result in an  array
        //TODO: Replace with your own netid
        //TODO: Replace with the algorithm used
        //TODO: Replace with the  array used
        // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        sortDirector(args[1],a,"a",args[0]);
        sortDirector(args[1],b,"b",args[0]);
        sortDirector(args[1],c,"c",args[0]);
        sortDirector(args[1],d,"d",args[0]);



    }
}


