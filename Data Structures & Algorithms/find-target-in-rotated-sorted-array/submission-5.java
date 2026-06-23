class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if(nums[pivot] == target) return pivot;

        // perform bs to find target in both side of the array 
        if(pivot > 0 && nums[0] <= target && target <= nums[pivot-1]){
            return binarySearch(nums, 0, pivot-1, target);
        } else {
            return binarySearch(nums, pivot+1, nums.length-1, target);
        }
    }

    private int findPivot(int[] nums){
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}