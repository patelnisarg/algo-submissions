class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // [-4,-1,-1,0,1,2]
        List<List<Integer>> output = new ArrayList<>();
        int i  = 0;
        while(i <= nums.length-3){
            int left = i+1;
            int right = nums.length-1;
            // since nums is sorted rest of the numbers will be > 0 
            if(nums[i] > 0) break; 
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    output.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    right--;
                    // while(left < right && nums[right+1] == nums[right]){
                    //     right--;
                    // }
                } else if(sum > 0){
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
            i++;
            while(i > 0 && i <= nums.length - 3 && nums[i] == nums[i-1]){
                i++;
            }
        }

        return output;
    }
}
