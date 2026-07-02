/**
*/
class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k){
        List<Integer> output = new ArrayList<>();
        // max-heap
        PriorityQueue<Integer> maxNum = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        HashMap<Integer, Integer> numFreq = new HashMap<>(); // key: num, value: freq

        int left = 0, right = 0;

        while(right < nums.length){
            // add to max-heap
            maxNum.add(nums[right]);
            numFreq.put(nums[right], numFreq.getOrDefault(nums[right], 0)+1);
            if((right-left+1) == k){
                // System.out.println("Looking for -- maxNum.peek(): " + maxNum.peek());
                // System.out.println("numFreq is: "+ numFreq);
                while(numFreq.getOrDefault(maxNum.peek(), 0) == 0){
                    maxNum.poll();
                }
                // add max num in the window to the output
                output.add(maxNum.peek());
                numFreq.put(nums[left], numFreq.get(nums[left])-1);                
                left++;
            }
            // System.out.println("At right = " + right + " the value is: " + numFreq);
            // System.out.println("At right = " + right + " the maxNum is: "+ maxNum);
            // System.out.println("output is:  " + output);
            right++;
        }
        

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
