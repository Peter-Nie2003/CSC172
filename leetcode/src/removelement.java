public class removelement {
    public int removeElement(int[] nums, int val) {
        int j=nums.length;
        for(int i=0;i<j;){
            if(nums[i]==val){
                nums[i]=nums[j-1];
                j--;
            }
            else{
                i++;
            }
        }
        return j;
    }
}
