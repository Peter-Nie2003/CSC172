Name: Peter Nie
email: jnie7@u.rochester.edu
CSC 172 - lab3
Other files:
    Link.java:the file from class, that play as a node in the LList class.
    List.java: A List interface from class. We implement in the LList class.
    LList.java:The LList class from class.
    sequencelist.java:A sequencelist <E> class extends LList<E> class to store the DNA or RNA
                      sequence. Overwrite the toString() method. Add an extra variable type T.
                       which is an enum.

DNAList.java:
    class variable:
                    sequence：a sequencelist<Character> array to store the sequence of type.
                    temp1:an array to store the RNA or DNA sequence temporary
                    temp2:a sequencelist to store the RNA or DNA sequence temporary
    DNAList(int size):
        How it works?
                    use the parameter size to new a sequencelist<Character> array in an appropriate length.

    insert(int pos,String a, String b):
        How it works?
                    * use String a to check what type we need to insert.
                    * use for loop to check do the String b which is the sequence satisfy the RNA or DNA sequence requirement.
                    * if the sequence satisfy the requirement, we check do the array[pos] is null or not. if there is null, we need to new a sequencelist first
                    * Then check the type variable of sequencelist. if type T is empty, set it as a DNA or RNA.And use for loop append every Character in String b.
                    * If type T is not empty. we need to use the method from LList.java clear() first and repeat the operation we do in type T is empty.

    insert(int pos):
        How it works?
                    * we check do the sequence[pos] is null or not. if there is null, we need to new a sequencelist first and set the type T as empty.
                    * else we just use clear() (method from LList.java) to remove all the element from the sequencelist in sequence[pos] and set the type T as empty.

    remove(int pos):
                    * check, if the sequencelist in sequence[pos] is null or type T is empty, we print out "No sequence to remove at specified position".
                    * else we just use  clear() (method from LList.java) to remove all the element from the sequencelist in sequence[pos] and set the type T as empty.

    print():
                    * use for loop to print every element in the array sequence
                    * in the for loop, we check if the element in each index is null first. If is null, we jump out and continue the for loop.
                    * if there is DNA and RNA type. we print it out use \t in an appropriate format. (We have Overwrite the toString() in the seqhencelist.java already)
                    * if there is empty type. we print the position and the type only.

    print(int pos):
                    * check, if the sequencelist in sequence[pos] is null.we print out "No sequence to print at specified position!".
                    * if there is empty type. we print out the empty type and "This is empty sequence".
                    * if there is DNA and RNA type. we print it out use \t in an appropriate format. (We have Overwrite the toString() in the seqhencelist.java already)

    clip(int pos,int start,int end):
                    * check, if the sequencelist in sequence[pos] is null or type T is empty, we print out "No sequence to clip at specified position".
                    * if start<0 print out "Invalid start index".
                    * if start>the length of sequencelist in pos position, we print out "Start index is out of bounds".
                    * if end>the length of sequencelist in pos position, we print out "End index is out of bounds".
                    * if start>end, we use clear() and set the type T as empty.
                    * if end-start+1 = the length of sequencelist in pos position, we use clear() and set the type T as empty.
                    * else we use moveToPos(start) to move the current pointer to start position.(the method we have in sequencelist.java)
                    * use counter to store the letter we need to delete, which counter = end - start +1.
                    * use while loop, every time use remove() to remove the letter in sequencelist and counter should decrease 1 every time.

    copy(int pos1,int pos2):
                    * check, if the sequencelist in sequence[pos1] is null or type T is empty, we print out "No sequence to copy at specified position".
                    * else we just set the sequencelist in sequence[pos2] equal the sequencelist in sequence[pos1]. Also the type should be equal too.

    transcribeRNA(int pos):
                    * check, if the sequencelist in sequence[pos] is null or type T is empty, we print out "No sequence to transcribe at specified position".
                    * if the sequencelist in sequence[pos] type T is RNA, we print out "Cannot transcribe RNA".
                    * else use moveToStart() to move the current pointer to the first Link in the sequencelist.(moveToStart() the method we have in the sequencelist.java)
                    * let temp1 be a new array that have same length with sequencelist we need to transcribe. And initiate the temp2.
                    * use for loop and next() to set every letter in sequencelist to temp1 array.
                    * Then iterate the temp1, if there is character 'T' in temp1, we append 'U' to the temp2 sequencelist.
                    * else we append the character we have in the temp1 to temp2.
                    * we set the sequencelist in sequence[pos] equal the temp2.

    main():
                    * use the first command from the terminal to initiate the DNAList in an appropriate size.use the element in args[0].we need to use Integer.parseInt() to cast the String to Integer first.
                    * use try and catch to throw the IOException when we read the input file.
                    * use BufferedReader to read the file from the terminal, use the element in args[1]. And variable commandline equal each line we read from the file.
                    * use while loop. The while loop will always work until the commandline equal null, which means we have read all the thing from the file.
                    * use an appropriate regex to seperate the commandline. Then use while loop and a counter variable i to add the String we get from seperate operation them in the String[] command.
                    * if the command[0] equal"insert":
                        1.when i>2, which mean we have more that two String in this line. So we call the method insert(Integer.parseInt(command[1]),command[2],command[3]).
                        2.else, we call the method insert(Integer.parseInt(command[1])).
                    * if the command[0] equal"print":
                        1.when i>2, we call the method print(Integer.parseInt(command[1]).
                        2.else, we call the method print().
                    * if the command[0] equal"remove",we call the method Integer.parseInt(command[1]).
                    * if the command[0] equal"copy",we call the method copy(Integer.parseInt(command[1]),Integer.parseInt(command[2]).
                    * if the command[0] equal"transcribe",we call the method transcribeRNA(Integer.parseInt(command[1])).
                    * if the command[0] equal"clip",we call the method clip(Integer.parseInt(command[1]),Integer.parseInt(command[2]),Integer.parseInt(command[3])).

    ***How to run the DNAList.java:***
        1.javac DNAList.java
        2.java DNAList <array-size> <command-file>
        3.the command-file should in the same folder with other file.

