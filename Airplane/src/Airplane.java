import java.util.Scanner;

public class Airplane {

    private String name;
    private float TOW_min, Tow_max, range,speed,hourly_cost,fuel_burn;

    Airplane(String name,float TOW_min,float Tow_max,float range,float speed,float hourly_cost,float fuel_burn){
        this.name=name;
        this.TOW_min=TOW_min;
        this.Tow_max=Tow_max;
        this.range=range;
        this.speed=speed;
        this.hourly_cost=hourly_cost;
        this.fuel_burn=fuel_burn;
    }

    private float profitCal(float mass,float distance,float payment){
        return payment-((distance/speed)*hourly_cost)-(fuel_burn*(mass+TOW_min)*(distance/speed));
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        scanner.nextLine();
        Airplane [] Airplanes=new Airplane [num];
        float curProfit = 0,totalProfit=0;
        String x="";
        int pointer;
        for(int i=0;i<num;i++) {
            String a=scanner.nextLine();
            String[] lines = a.split(" ");
            Airplanes[i] = new Airplane(lines[0], Float.parseFloat(lines[1]), Float.parseFloat(lines[2]), Float.parseFloat(lines[3]), Float.parseFloat(lines[4]), Float.parseFloat(lines[5]), Float.parseFloat(lines[6]));
        }
        while(true){
            float[] comparator=new float[num];
            String next= scanner.nextLine();
            if(next.equals("quit")) break;
            String[] contract= next.split(" ");
            for(int j=0;j<num;j++) {
                Float temp =Airplanes[j].profitCal(Float.parseFloat(contract[0]), Float.parseFloat(contract[1]), Float.parseFloat(contract[2]));
                comparator[j]=temp;
            }
            float max=comparator[0];
            pointer=0;
            for(int k=1;k<num;k++){
                if (comparator[k]>max) {max=comparator[k];pointer=k;}
            }
            if(max<0) x=x+String.format("%s\n","decline");
            else {x=x+String.format("%s %.2f\n",Airplanes[pointer].name,max); totalProfit+=max;}
        }
        System.out.print(x);
        System.out.printf("Profit: %.2f",totalProfit);


        //String str1 = String.format("%s\n","abc");
        //String str2 = String.format("%s\n","abc");
        //System.out.println(str1+str2);
    }
}
