class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
    
        for(int i = 0; i <= nums.length-3; i++){
            // base case: if curr num is > 0, all nums to the right 
            // will be > 0
            if(nums[i] > 0) break;
    
            // base case: avoid duplicates 
            if(i > 0 && nums[i-1] == nums[i]) continue;

            int left = i+1;
            int right = nums.length-1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // avoid duplicates in the next iterations 
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
            }
        }
        return output;
    }
}
