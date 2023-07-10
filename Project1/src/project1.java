import java.util.ArrayList;
import java.util.Scanner;

public class project1 {

    static String store[][];

    static String compare[][] = new String[6][6];

    static ArrayList <Integer> row;

    static ArrayList <Integer> column;

    static ArrayList <Integer> maxArr;

    static int x;

    static int y;

    static int z;

    static int counter;

    static boolean cp;

    // constructor that creates a new '6 * 6' 2D array, with 2 new random spots
    project1(){
        store = new String[6][6];
        for(int i = 0; i < 6; i++){
            store[0][i] = "-";
        }
        for(int i = 0; i < 6; i++){
            store[5][i] = "-";
        }
        for(int i = 1; i < 5; i++){
            store[i][5] = "|";
        }
        for(int i = 1; i < 5; i++){
            store[i][0] = "|";
        }
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                store[i][j] = "*";
            }
        }
        getRandomNum();
        getRandomNum();
        update();
    }

    // method that counts the number of '*' in the current matrix
    static int countStr(){
        int c = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (store[i][j].equals("*")){
                    c++;
                }
            }
        }
        return c;
    }

    // method that compares these two 2D arrays to see whether the player has made a valid move
    static boolean compare2D(){
        boolean haveChange = true;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (compare[i][j].equals(store[i][j])){
                    haveChange = false;
                }
                else{
                    haveChange = true;
                    return haveChange;
                }
            }
        }
        return haveChange;
    }

    // method that updates the board in store[][] into compare[][]
    static void update(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                compare[i][j] = store[i][j];
            }
        }
    }

    // method that determines the row has same numbers next to each other
    static boolean noSameR(){
        boolean noSame = false;
        int same = 0;
        for (int i = 1; i < 5; i++){
            toRowL(i);
            for (int j = 0; j < 3; j++){
                if (row.get(j).equals(row.get(j+1))){
                    same++;
                }
            }
        }
        if (same == 0){
            noSame = true;
        }
        return noSame;
    }

    // method that determines the column has same numbers next to each other
    static boolean noSameC(){
        boolean noSame = false;
        int same = 0;
        for (int i = 1; i < 5; i++){
            toColumnU(i);
            for (int j = 0; j < 3; j++){
                if (column.get(j).equals(column.get(j+1))){
                    same++;
                }
            }
        }
        if (same == 0){
            noSame = true;
        }
        return noSame;
    }

    // method that prints the '6 * 6' 2D array store[][]
    static void printArr(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                System.out.printf("%11s",store[i][j]);
            }
            System.out.println();
        }
    }

    // method that generates new element of '2' and '4'
    static void getRandomNum(){
        x = (int) (Math.random() * 4 + 1);
        y = (int) (Math.random() * 4 + 1);
        if (countStr() != 0){
            if (store[x][y].equals("*")){
                if (Math.random() < 0.8){
                    store[x][y] = "2";
                }
                else {
                    store[x][y] = "4";
                }
            }
            else{
                getRandomNum();
            }
        }
    }

    // method that turns certain row of the 2D array into an integer arraylist
    static void toRowL(int rowNum){
        row = new ArrayList<>();
        for (int i = 1; i < 5; i++){
            if (!store[rowNum][i].equals("*")){
                row.add(Integer.parseInt(store[rowNum][i]));
            }
        }
    }

    // method that turns certain row of the 2D array into an integer arraylist in anti direction
    static void toRowR(int rowNum){
        row = new ArrayList<>();
        for (int i = 4; i > 0; i--){
            if (!store[rowNum][i].equals("*")){
                row.add(Integer.parseInt(store[rowNum][i]));
            }
        }
    }

    // method that turns certain column of the 2D array into an integer arraylist
    static void toColumnU(int columnNum){
        column = new ArrayList<>();
        for (int i = 1; i < 5; i++){
            if (!store[i][columnNum].equals("*")){
                column.add(Integer.parseInt(store[i][columnNum]));
            }
        }
    }

    // method that turns certain column of the 2D array into an integer arraylist in up-side-down direction
    static void toColumnD(int columnNum){
        column = new ArrayList<>();
        for (int i = 4; i > 0; i--){
            if (!store[i][columnNum].equals("*")){
                column.add(Integer.parseInt(store[i][columnNum]));
            }
        }
    }

    // method that gets the maximum value of the matrix
    static Integer getMax(){
        maxArr = new ArrayList<>();
        for (int i = 1; i < 5; i++){
            for (int j = 1; j < 5; j++){
                if (!store[i][j].equals("*")){
                    maxArr.add(Integer.parseInt(store[i][j]));
                }
            }
        }
        int max = maxArr.get(0);
        for (int i = 1; i < maxArr.size(); i++){
            if (maxArr.get(i) > max){
                max = maxArr.get(i);
            }
        }
        return max;
    }

    // movements:
    static void left(){
        for (int i = 1; i < 5; i++){
            toRowL(i);
            if (row.size() >= 2){
                for (int j = 0; j < row.size()-1; j++){
                    if (row.get(j).equals(row.get(j+1)) && row.get(j) != 2048){
                        row.set(j,2 * row.get(j));
                        row.remove(j+1);
                    }
                }
            }
            for (int k = 1; k < 5; k++){
                if (k <= row.size()){
                    store[i][k] = row.get(k-1).toString();
                }
                else{
                    store[i][k] = "*";
                }
            }
        }
        if (compare2D()){
            getRandomNum();
            counter++;
            clearConsole();
            printArr();
            System.out.println("step"+counter);
        }
        else{
            System.out.println("your last move hasn't change the matrix");
        }
        update();
    }

    static void up(){
        for (int i = 1; i < 5; i++){
            toColumnU(i);
            if (column.size() >= 2){
                for (int j = 0; j < column.size()-1; j++){
                    if (column.get(j).equals(column.get(j+1)) && column.get(j) != 2048){
                        column.set(j,2 * column.get(j));
                        column.remove(j+1);
                    }
                }
            }
            for (int k = 1; k < 5; k++){
                if (k <= column.size()){
                    store[k][i] = column.get(k-1).toString();
                }
                else{
                    store[k][i] = "*";
                }
            }
        }
        if (compare2D()){
            getRandomNum();
            counter++;
            clearConsole();
            printArr();
            System.out.println("step"+counter);
        }
        else{
            System.out.println("your last move hasn't change the matrix");
        }
        update();
    }

    static void right(){
        for (int i = 1; i < 5; i++){
            toRowR(i);
            if (row.size() >= 2){
                for (int j = 0; j < row.size()-1; j++){
                    if (row.get(j).equals(row.get(j+1)) && row.get(j) != 2048){
                        row.set(j,2 * row.get(j));
                        row.remove(j+1);
                    }
                }
            }
            for (int k = 4; k > 0; k--){
                if (4-k <= row.size()-1){
                    store[i][k] = row.get(4-k).toString();
                }
                else{
                    store[i][k] = "*";
                }
            }
        }
        if (compare2D()){
            getRandomNum();
            counter++;
            clearConsole();
            printArr();
            System.out.println("step"+counter);
        }
        else{
            System.out.println("your last move hasn't change the matrix");
        }
        update();
    }

    static void down(){
        for (int i = 1; i < 5; i++){
            toColumnD(i);
            if (column.size() >= 2){
                for (int j = 0; j < column.size()-1; j++){
                    if (column.get(j).equals(column.get(j+1)) && column.get(j) != 2048){
                        column.set(j,2 * column.get(j));
                        column.remove(j+1);
                    }
                }
            }
            for (int k = 4; k > 0; k--){
                if (4-k <= column.size()-1){
                    store[k][i] = column.get(4-k).toString();
                }
                else{
                    store[k][i] = "*";
                }
            }
        }
        if (compare2D()){
            getRandomNum();
            counter++;
            clearConsole();
            printArr();
            System.out.println("step"+counter);
        }
        else{
            System.out.println("your last move hasn't change the matrix");
        }
        update();
    }

    // methode that clear the screen
    static void clearConsole(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    // method that restarts a new game when the old game is still running
    static void restart(){
        store = new String[6][6];
        for(int i = 0; i < 6; i++){
            store[0][i] = "-";
        }
        for(int i = 0; i < 6; i++){
            store[5][i] = "-";
        }
        for(int i = 1; i < 5; i++){
            store[i][5] = "|";
        }
        for(int i = 1; i < 5; i++){
            store[i][0] = "|";
        }
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                store[i][j] = "*";
            }
        }
        getRandomNum();
        getRandomNum();
        update();
    }


    public static void main(String[] args) {

        System.out.println("Use 'w a s d' to control the game");

        project1 a = new project1();
        printArr();
        Scanner scan = new Scanner(System.in);

        while (true){
            String order = scan.next();
            if (order.equals("a")){
                left();
            }
            if (order.equals("d")){
                right();
            }
            if (order.equals("w")){
                up();
            }
            if (order.equals("s")){
                down();
            }
            if(order.equals("r")){
                System.out.println("Restart?  (Type yes or no)");
                String choice1 = scan.next();
                if(choice1.equals("yes")){
                    restart();
                    clearConsole();
                    printArr();
                    counter=0;
                }
                else{
                    System.out.println("Continue the game, use 'w a s d' to control the game");
                    continue;

                }
            }
            if(order.equals("q")){
                System.out.println("Quit?  (Type yes or no)");
                String choice1 = scan.next();
                if(choice1.equals("yes")){
                    break;
                }
                else{
                    System.out.println("Continue the game,use 'w a s d' to control the game");
                    continue;

                }
            }
            if(countStr() == 0){
                if(noSameR() && noSameC()){
                    System.out.println("you lose");
                    break;
                }
            }
            if(getMax() == 2048){
                System.out.println("You win!");
            }
        }
        System.out.println("You totally make "+counter+" valid moves");
        System.out.println("The max number on the board is "+getMax()+" !");
    }
}