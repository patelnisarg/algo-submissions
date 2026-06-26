class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        // 1st part: calculate the product sum uptil the current num
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                output[i] = 1;
            } else {
                output[i] = nums[i-1] * output[i-1];
            }
        }
        // System.out.println("output pre-product: " + Arrays.toString(output));
        int postProduct = 1;
        for(int i = nums.length-1; i >= 0; i--){
            if(i == nums.length - 1){
                output[i] = output[i] * postProduct;
            } else {
                output[i] = output[i] * postProduct;
            }
            postProduct = postProduct * nums[i];
        }
        // System.out.println("output post-product: " + Arrays.toString(output));
        return output;
    }
}  
