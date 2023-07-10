
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Lab2 {
	/*
	4 different type static arrays and arraylist to store the input we read from the file.
	 */
	static Integer[] integerarr;
	static Double[] doublearr;
	static Character[] chararr;
	static String[] strarr;

	static int len;

	static ArrayList<String> stringarraylist;

	static ArrayList<Character> chararraylist;

	static ArrayList<Integer> integerarraylist;

	static ArrayList<Double> doublearraylist;


	/*
	IO to read the input data
 	*/

	private static final String CHARSET_NAME = "UTF-8";


	private static final Locale LOCALE = Locale.US;

	private Scanner scanner;
	public Lab2(String name) {
		if (name == null) throw new IllegalArgumentException("argument is null");
		try {

			File file = new File(name);
			if (file.exists()) {

				FileInputStream fis = new FileInputStream(file);
				scanner = new Scanner(new BufferedInputStream(fis), CHARSET_NAME);
				scanner.useLocale(LOCALE);
			}
		}
		catch (IOException ioe) {
			throw new IllegalArgumentException("Could not open " + name, ioe);
		}
	}
	public String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		}
		catch (NoSuchElementException e) {
			line = null;
		}
		return line;
	}
	public boolean hasNextLine() {
		return scanner.hasNextLine();
	}


	// print Object tye array
	static void printArrayNonGen(Object[] ob){
		String str="";
		if(ob.length==0){
			System.out.println("");
		}
		else{
		for(int i=0;i<ob.length;i++) {
			if(ob[i]==null){
				str=str+" ,";
			}
			else {
				str = str + ob[i] + ",";
			}
		}
		str=str.substring(0,str.length()-1);
		System.out.println(str);}
		/*
		use a string variable add all the element from array up,
		them get the substring of the object from first to penultimate position.
		Print it out. In integer array or Double array, if there is null, we print out a " ".
		All the remaining print method have same logic.
		 */
	}

	//4 overload printArray method for 4 different array type, Integer,Float,Character,String
	static void printArray(Integer[] intarr){
		String str="";
		if(intarr.length==0){
			System.out.println("");
		}
		else{
		for(int i=0;i<intarr.length;i++) {
			if(intarr[i]==null){
				str=str+" ,";
			}
			else {
				str = str + intarr[i] + ",";
			}
		}
		str=str.substring(0,str.length()-1);
		System.out.println(str);
	}}

	static void printArray(Double[] doublearr){
		String str="";
		if(doublearr.length==0){
			System.out.println("");
		}
		else{
		for(int i=0;i<doublearr.length;i++) {
			if(doublearr[i]==null){
				str=str+" ,";
			}
			else {
				str = str + doublearr[i] + ",";
			}
		}
		str=str.substring(0,str.length()-1);
		System.out.println(str);
	}}

	static void printArray(Character[] chararr){
		String str="";
		if(chararr.length==0){
			System.out.println("");
		}
		else{
		for(int i=0;i<chararr.length;i++) {
			if(chararr[i]==null){
				str=str+" ,";
			}
			else {
				str = str + chararr[i] + ",";
			}
		}
		str=str.substring(0,str.length()-1);
		System.out.println(str);
	}}

	static void printArray(String[] strarr){
		String str="";
		if(strarr.length==0){
			System.out.println("");
		}
		else{
		for(int i=0;i<strarr.length;i++) {

			if(strarr[i]==null){
				str=str+" ,";
			}
			else {
				str = str + strarr[i] + ",";
			}
		}
		str=str.substring(0,str.length()-1);
		System.out.println(str);
	}}
	//Generic method print array
	static<T> void printArrayGen(T[] gerarr) {
		String str="";
		if(gerarr.length==0){
			System.out.println("");
		}
		else{
		for(int i=0;i<gerarr.length;i++) {

			if(gerarr[i]==null){
				str=str+" ,";
			}
			else {
				str = str + gerarr[i] + ",";
			}
		}
		str=str.substring(0,str.length()-1);
		System.out.println(str);
	}}
	//get Max method
	static Comparable getMax(Comparable [] anArray) {
		if(anArray.length==0){
			String back="There is no element in array, so we can not compare";
			return back="There is no element in array, so we can not compare";
		}
		else{
		Comparable max=anArray[0];
		for(int i=1;i<anArray.length;i++){
			if(max==null && anArray[i]==null){
				max=anArray[i+1];
			}
			else if(max==null){
				max=anArray[i];
			}
			else if(anArray[i]==null){
				continue;
			}
			else if (max.compareTo(anArray[i])<0){
				max=anArray[i];
			}
		}
		return max;
		/*
		use the for loop to compare the rest of element with the variable max.
		If bigger than max, we just store than into the max.
		 */

	}}


	//getMax method use Generic
	static<T extends Comparable>Comparable getMaxGen(T []gerarr ){
		if(gerarr.length==0){
			String back="There is no element in array, so we can not compare";
			return back="There is no element in array, so we can not compare";
		}
		else{
		T max=gerarr[0];
		for(int i=1;i<gerarr.length;i++){
			if(max==null && gerarr[i]==null){
				max=gerarr[i+1];
			}
			else if(max==null){
				max=gerarr[i];
			}
			else if(gerarr[i]==null){
				continue;
			}
			else if (max.compareTo(gerarr[i])<0){
				max=gerarr[i];
			}
		}
		return max;

	}}
	/*
	main function
	read input data
	store them in the array
	test the method.
	more specific thing all in the readme.
	 */
	public static void main(String[] args) {
		Lab2 a = new Lab2("input.txt");


		int i=0;
		while(a.hasNextLine()){
			String input= a.readLine();
			String[] array = input.split(" ");
			len=array.length;
			if(i==0 && input.length()!=0){
				integerarraylist= new ArrayList<>();
				for(int j=0;j<len;j++){
					int tmp= input.indexOf(" ",1);
					if(tmp==-1){
						if(!input.equals(" ")){
							integerarraylist.add(Integer.parseInt(input));}
						else{
							integerarraylist.add(null);
						}
						break;
					}
					String in=input.substring(0,tmp);
					if(!in.equals(" ")){
						integerarraylist.add(Integer.parseInt(in));}
					else{
						integerarraylist.add(null);
					}
					input=input.substring(tmp+1);
				}
				integerarr= new Integer[integerarraylist.size()];
				for(int k=0; k< integerarraylist.size();k++) {
					integerarr[k] = integerarraylist.get(k);
				}
			}
			if(i==0 && input.length()==0){
			integerarr = new Integer[0];}

			if(i==1 && input.length()!=0 ){
				doublearraylist= new ArrayList<>();
				for(int j=0;j<len;j++){
					int tmp= input.indexOf(" ",1);
					if(tmp==-1){
						if(!input.equals(" ")){
							doublearraylist.add(Double.parseDouble(input));}
						else{
							doublearraylist.add(null);
						}
						break;
					}
					String in=input.substring(0,tmp);
					if(!in.equals(" ")){
						doublearraylist.add(Double.parseDouble(in));}
					else{
						doublearraylist.add(null);
					}
					input=input.substring(tmp+1);
				}
				doublearr= new Double[doublearraylist.size()];
				for(int k=0; k< doublearraylist.size();k++) {
					doublearr[k] = doublearraylist.get(k);
				}
			}

			if(i==1 && input.length()==0){
				doublearr= new Double[0];}

			if(i==2 && input.length()!=0){
				//initiate Character array
				chararraylist = new ArrayList<>();
				for(int j=0;j<len;j++){
					int tmp= input.indexOf(" ",1);
					if(tmp==-1){
						chararraylist.add(input.charAt(0));
						break;
					}
					String in=input.substring(0,tmp);
					chararraylist.add(in.charAt(0));
					input=input.substring(tmp+1);

				}
				chararr= new Character[chararraylist.size()];
				for(int k=0; k< chararraylist.size();k++){
					chararr[k]=chararraylist.get(k);
				}
			}
			if(i==2 && input.length()==0 ){
			chararr=new Character[0];}
			if(i==3 && input.length()!=0 ){
				//initiate String arraylist
				stringarraylist= new ArrayList<>();
				for(int j=0;j<len;j++){
					int tmp= input.indexOf(" ",1);
					if(tmp==-1){
						stringarraylist.add(input);
						break;
					}
					String in=input.substring(0,tmp);
					stringarraylist.add(in);
					input=input.substring(tmp+1);
				}
				strarr= new String[stringarraylist.size()];
				for(int k=0; k< stringarraylist.size();k++) {
					strarr[k] = stringarraylist.get(k);
				}
			}
			if(i==3 && input.length()==0 ){
				strarr= new String[0];}


			i++;
		}
		printArrayNonGen(integerarr);
		printArrayNonGen(doublearr);
		printArrayNonGen(chararr);
		printArrayNonGen(strarr);

		printArray(integerarr);
		printArray(doublearr);
		printArray(chararr);
		printArray(strarr);

		printArrayGen(integerarr);
		printArrayGen(doublearr);
		printArrayGen(chararr);
		printArrayGen(strarr);

		System.out.println(getMax(integerarr));
		System.out.println(getMax(doublearr));
		System.out.println(getMax(chararr));
		System.out.println(getMax(strarr));
		System.out.println(getMaxGen(integerarr));
		System.out.println(getMaxGen(doublearr));
		System.out.println(getMaxGen(chararr));
		System.out.println(getMaxGen(strarr));


	}
}