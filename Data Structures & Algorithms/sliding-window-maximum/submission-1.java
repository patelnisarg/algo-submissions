/**
    - for each window of size k, add the max value to a list
    - time complexity: o(n), we iterate through the nums arr of size n 
    - space complexity: o(n), ignoring the output arr, we store idex of the numbers 
    in deque. worst case scenario k == nums.length and all nums are in decreasing order. 
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;
        List<Integer> output = new ArrayList<>(); // 2

        while(right < nums.length){
            if(deque.isEmpty() || nums[deque.peekLast()] > nums[right]){
                deque.addLast(right);
            } else if(nums[deque.peekLast()] < nums[right]) {
                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                    deque.removeLast();
                }
                deque.addLast(right);
            }

            if((right-left+1) == k){
                output.add(nums[deque.peekFirst()]);
                if(left == deque.peekFirst()){
                    deque.removeFirst();
                }
                left++;
            }
            right++;
        }

        int[] result = new int[output.size()];
        for(int i = 0; i < output.size(); i++){
            result[i] = output.get(i);
        }

        return result;
    }
}
