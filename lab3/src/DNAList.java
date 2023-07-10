import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DNAList<E> {
    sequencelist<Character>[] sequence;   //a sequencelist<Character> array to store the sequence of type
    Character[] temp1;      //an array to store the RNA or DNA sequence temporary
    sequencelist<Character> temp2;          //a sequencelist to store the RNA or DNA sequence temporary


    //constructor
    DNAList(int size){
        sequence =new sequencelist[size];

    }


    //set the RNA or DNA sequence in appropriate position in the array
    public void insert(int pos,String a, String b) {
        //use String a to check what type we need to insert.
        if (a.equals("RNA")) {
            for (int i = 0; i < b.length(); i++) {
                if ('A' != b.charAt(i) && 'C' != b.charAt(i) && 'G' != b.charAt(i) && 'U' != b.charAt(i)) {
                    System.out.println("Error occurred while inserting");
                    return;
                }
            }
            //null, we need to new a sequencelist first
            if(sequence[pos]==null){
                sequence[pos]=new sequencelist<>();
            }
            //empty, set it as a DNA or RNA.And use for loop append every Character in String b.
            if (sequence[pos].T==type.empty) {
                for (int j = 0; j < b.length(); j++) {
                    Character c = b.charAt(j);
                    sequence[pos].append(c);
                }
                sequence[pos].T=type.RNA;
            } else {
                sequence[pos].T=type.RNA;
                sequence[pos].clear();
                for (int j = 0; j < b.length(); j++) {
                    Character c = b.charAt(j);
                    sequence[pos].append(c);
                }

            }
        }
        if (a.equals("DNA")) {
            for (int i = 0; i < b.length(); i++) {
                if ('A' != b.charAt(i) && 'C' != b.charAt(i) && 'G' != b.charAt(i) && 'T' != b.charAt(i)) {
                    System.out.println("Error occurred while inserting");
                    return;
                }
            }
            //null, we need to new a sequencelist first
            if(sequence[pos]==null){
                sequence[pos]=new sequencelist<>();
            }
            ////empty, set it as a DNA or RNA.And use for loop append every Character in String b.
            if (sequence[pos].T==type.empty) {
                for (int j = 0; j < b.length(); j++) {
                    Character c = b.charAt(j);
                    sequence[pos].append(c);

                }
                sequence[pos].T=type.DNA;
            } else {
                sequence[pos].T=type.DNA;
                sequence[pos].clear();
                for (int j = 0; j < b.length(); j++) {
                    Character c = b.charAt(j);
                    sequence[pos].append(c);
                }

            }
        }
    }

    //set an empty sequence in appropriate position in the array
    public void insert(int pos){
        ////null, we need to new a sequencelist first
        if(sequence[pos]==null){
            sequence[pos]=new sequencelist<>();
            sequence[pos].T=type.empty;
        }
        else{
            sequence[pos].clear();
            sequence[pos].T=type.empty;
        }

    }

    //remove the sequence in the appropriate position from the array

    public void remove(int pos){
        if(sequence[pos]==null){

            System.out.println("No sequence to remove at specified position");
        }
        else if(sequence[pos].T==type.empty){
            System.out.println("No sequence to remove at specified position");
        }
        //clear sequencelist and set empty
        else{
            sequence[pos].clear();
            sequence[pos].T=type.empty;

        }

    }


    //print out all the no empty sequence from array
    public void print(){
        for(int i=0;i< sequence.length;i++){
            //null, jump out and continue the for loop
            if(sequence[i]==null){
                continue;
            }
            else if(sequence[i]!=null&&sequence[i].T!=type.empty){
                System.out.println(i+"\t"+sequence[i].T+"\t"+sequence[i]+"\t");
            }
            else if(sequence[i].T==type.empty){
                System.out.println(i+"\t"+sequence[i].T+"\t");
            }

        }
    }
    //print out the sequence from appropriate position in the array
    public void print(int pos) {
        if (sequence[pos] == null) {
            System.out.println("No sequence to print at specified position!");
        }
        else if (sequence[pos].T == type.empty) {
                System.out.println(sequence[pos].T+"\t"+"This is empty sequence"+"\t");
            }
        else {
                System.out.println(sequence[pos].T + "\t" + sequence[pos] + "\t");
            }


    }

    //clip the sequence in array that in pos index from index start to index end
    public void clip(int pos,int start,int end){
        //null,empty. nothing to clip
        if(sequence[pos]==null){
            System.out.println("No sequence to clip at specified position");
        }

        else if(sequence[pos].T==type.empty){
            System.out.println("No sequence to clip at specified position");
        }
        //Invalid start index
        else if(start<0){
            System.out.println("Invalid start index");
        }
        //Start index is out of bounds
        else if(start> sequence[pos].length()-1 ){
            System.out.println("Start index is out of bounds");
        }
        //End index is out of bounds
        else if(end>sequence[pos].length()-1){
            System.out.println("End index is out of bounds");
        }
        else if(start>end){
            sequence[pos].clear();
            sequence[pos].T=type.empty;
        }
        //the clip length equal the length of sequencelist
        else if(end-start+1==sequence[pos].length()){
            sequence[pos].clear();
            sequence[pos].T=type.empty;
        }
        else{
            sequence[pos].moveToPos(start);
            int counter = end-start+1;
            while(counter>0){
                sequence[pos].remove();
                counter--;
            }

        }
    }
    //copy the sequence of DNA or RNA from pos1 to pos2 in array.
    public void copy(int pos1,int pos2){
        //null,empty. nothing to copy
        if(sequence[pos1]==null){
            System.out.println("No sequence to copy at specified position");

        }
        else if(sequence[pos1].T==type.empty){
            System.out.println("No sequence to copy at specified position");
        }
        //set the sequencelist in sequence[pos2] equal the sequencelist in sequence[pos1]. Also the type should be equal too.
        else{
            sequence[pos2]=sequence[pos1];
            sequence[pos2].T=sequence[pos1].T;
        }
    }

    //transcribe the DNA to RNA sequence in pos index
    public void transcribeRNA(int pos){
        //null,empty nothing to transcribe.
        if(sequence[pos]==null){
            System.out.println("No sequence to transcribe at specified position");
        }
        else if(sequence[pos].T==type.empty){
            System.out.println("No sequence to transcribe at specified position");
        }
        //type is RNA, canot transcribe
        else if(sequence[pos].T==type.RNA){
            System.out.println("Cannot transcribe RNA");
        }
        else {
            sequence[pos].moveToStart();
            temp1=new Character[sequence[pos].length()];
            temp2 = new sequencelist<>();
            for(int i=0;sequence[pos].curr.next()!=null;i++){
                temp1[i]=sequence[pos].getValue();
                sequence[pos].next();
            }
            for(int j=0;j<=temp1.length-1;j++){
                if(temp1[j]=='T' ){
                    temp2.append('U');
                }
                else{
                    temp2.append(temp1[j]);
                }

                sequence[pos]=temp2;
                sequence[pos].T=type.RNA;
            }
        }
    }

    /*main method,
    read the input from user.(the size of array and a file call "in.txt" include the command
    use regex seperate the command in array.
    check which method the command use and call it.
     */
    public static void main(String[] args) {

        DNAList DNA = new DNAList(Integer.parseInt(args[0]));
        try{
            BufferedReader bf = new BufferedReader(new FileReader(args[1]));
            String commandline ;
            while((commandline =bf.readLine())!=null){
            String rule = "[A-Z|a-z|0-9|-[0-9]]+";
            Pattern r = Pattern.compile(rule);
            Matcher x = r.matcher(commandline);
            String[] command = new String[5];
            int i=0;
            
            while(x.find()){
                command[i] = x.group();
                i++;
            }
            if(command[0].equals("insert")){
                if(i>2){
                    DNA.insert(Integer.parseInt(command[1]),command[2],command[3]);
                }
                else{
                    DNA.insert(Integer.parseInt(command[1]));
                }
            }
            else if(command[0].equals("print")){
                if(i>1){
                    DNA.print(Integer.parseInt(command[1]));
                }
                else{
                    DNA.print();
                }
            }
            else if(command[0].equals("remove")){
                DNA.remove(Integer.parseInt(command[1]));
            }
            else if(command[0].equals("copy")){
                DNA.copy(Integer.parseInt(command[1]),Integer.parseInt(command[2]));

            }
            else if(command[0].equals("transcribe")){
                DNA.transcribeRNA(Integer.parseInt(command[1]));
            }
            else{
                DNA.clip(Integer.parseInt(command[1]),Integer.parseInt(command[2]),Integer.parseInt(command[3]));

            }}}
        catch(IOException e){
            System.out.println("There is no that file");
        }
        }

    }

