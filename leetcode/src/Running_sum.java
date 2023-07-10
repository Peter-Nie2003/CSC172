
public class Running_sum {
    public int[] runningSum(int[] nums) {
        int [] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){result[0]=nums[0];continue;}
            result[i]=result[i-1]+nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

