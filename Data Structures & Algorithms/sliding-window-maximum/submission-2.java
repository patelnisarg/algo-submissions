/**
*/
class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k){
        List<Integer> output = new ArrayList<>();
        // max-heap
        PriorityQueue<Integer> maxNum = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        Deque<Integer> stack = new ArrayDeque<>();

        int left = 0, right = 0;

        while(right < nums.length){
            // add to max-heap
            maxNum.add(nums[right]);
            if(maxNum.size() == k){
                output.add(maxNum.peek());
                while(maxNum.peek() != nums[left]){
                    stack.addFirst(maxNum.poll());
                }
                maxNum.poll();
                while(!stack.isEmpty()){
                    maxNum.add(stack.removeFirst());
                }
                left++;
            }
            right++;
        }
        

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
