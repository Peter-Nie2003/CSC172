public class isPalindrome {
    public boolean isPalindrome(int x) {
        /*
        String a= Integer.toString(x);
        String b= new StringBuilder(a).reverse().toString();
        return a.equals(b);*/
        //数学方法
        if(x<=0 || x%10==0) return false;
        int reverse_num=0;
        while(x>reverse_num){
            reverse_num=reverse_num*10+x%10;
            x=x/10;
        }
        return x==reverse_num || x==reverse_num/10;
    }
}
