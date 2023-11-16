public class Main {
    public static void main(String[] args) {
        int outcome[] = new int[2];
        int nums[]={1,2,3,4};
        outcome= twoSum(nums,3);
    }
    public static int[] twoSum(int[] nums, int target) {
        // int[] result = new int[2];
        int[] result = {0,0};
        for(int i: nums){
            for(int j= i+1; j<nums.length;j++){
                if((nums[i]+nums[j]) == target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        System.out.println(result[1]);
        return result;
    }
}