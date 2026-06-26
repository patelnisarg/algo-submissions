class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int num : nums){
            if(num == 0) {
                zeroCount++; // skip multiplying this number
                continue;
            }
            product *= num;
        }

        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(zeroCount == 0) {
                output[i] = product / nums[i];
            } else if(zeroCount == 1 && nums[i] == 0){
                output[i] = product;
            } else {
                output[i] = 0;
            }
        }

        return output;
    }
}  
