public class removeDuplicate {
    public static int removeDuplicates(int[] nums) {
        int p=0;
        for(int q=1;q<nums.length;q++){
            if(nums[p]!=nums[q] && q-p>0){
                nums[++p]=nums[q];
            }
            //q++;
        }
        return p+1;
    }
    public static void main(String[] args) {
        removeDuplicate.removeDuplicates(new int[]{1, 1, 2});
        System.out.println();
    }
}
