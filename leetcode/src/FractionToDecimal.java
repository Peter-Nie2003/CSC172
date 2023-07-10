import java.util.LinkedList;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator%denominator==0) return String.valueOf(numerator/denominator);
        else{
            LinkedList<Integer> save =new LinkedList<>();
            String decimal="";
            double temp=numerator%denominator;
            int mod=numerator%denominator;
            boolean negative=false;
            if((double)numerator/denominator<0) negative=true;
            while(true){
                if(mod==0) return numerator/denominator+"."+decimal;
                if(!save.contains(mod)) save.add(mod);
                else{
                    for(int i=0;i<save.size();i++){
                        if(save.get(i)==mod){
                            decimal=decimal.substring(0,i)+"("+decimal.substring(i,save.size())+")";
                            if(numerator/denominator==0 && negative){  return "-"+numerator/denominator+"."+decimal;}
                            else{return numerator/denominator+"."+decimal;}
                        }
                    }
                }
                if(negative){
                    decimal+=Math.abs(mod*10/denominator);
                    mod=Math.abs(mod*10%denominator);
                }else{
                decimal+=mod*10/denominator;
                mod=mod*10%denominator;}
            }

        }
    }
    public static void main(String[] args) {

    }
}
