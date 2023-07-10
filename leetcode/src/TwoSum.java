import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(target-nums[i])){
                int[] result=new int[]{hashmap.get(target-nums[i]),i};
                return result;
            }
            hashmap.put(nums[i],i);
        }
        return null;
    }
}
