import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static class yearAccount{
        int year;
        double Z;
        double Y;
        double K;
        double N;
        public yearAccount(double Y,double K,double N,double Z,int year){
            this.Y=Y; this.K=K; this.N=N; this.Z=Z;this.year=year;
        }

    }

    public static void calculate2(yearAccount a,yearAccount b){
        double Y_diff=Math.log(b.Y)-Math.log(a.Y);
        double K_diff=Math.log(b.K)-Math.log(a.K);
        double N_diff=Math.log(b.N)-Math.log(a.N);
        double Z_diff=Math.log(b.Z)-Math.log(a.Z);
        System.out.println("Year:"+a.year+"-"+b.year+"   Y growth rate: "+Y_diff+"\t"+"K growth rate: "+K_diff+"\t"+"N growth rate: "+N_diff+"\t"+"Z growth rate: "+Z_diff);
    }
    public static double calculate1(double Y,double K,double N){
        double k=Math.pow(K,0.45);
        double n=Math.pow(N,0.55);
        return Y/(k*n);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
        String command;
        yearAccount[] arrAcc=new yearAccount[13];
        int year=1995;
        int i=0;
        while((command= reader.readLine())!=null){
            String[] arr=new String[3];
            arr=command.split(" ");
            System.out.print("Year: "+year+"  z:  ");
            Double Z=calculate1(Double.parseDouble(arr[0]),Double.parseDouble(arr[1]),Double.parseDouble(arr[2]));
            System.out.println(Z);
            yearAccount temp= new yearAccount(Double.parseDouble(arr[0]),Double.parseDouble(arr[1]),Double.parseDouble(arr[2]),Z,year);
            arrAcc[i]=temp;
            year++;i++;
        }
        for(int j=1;j< arrAcc.length;j++){
            calculate2(arrAcc[j-1],arrAcc[j]);
        }

    }
}