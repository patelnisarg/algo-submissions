// T: O(NlogM), N is the size of nums arr and M is the count of distinct num in nums 
// S: O(N+M), N is the size of nums arr and M is the count of distinct num in nums 
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]); // sorting based on freq
            return Integer.compare(b[0], a[0]); // sorting descending since same freq
        });

        for(Map.Entry<Integer, Integer> numFreq : freqMap.entrySet()){
            minHeap.add(new int[]{numFreq.getKey(), numFreq.getValue()});
        }

        int[] output = new int[nums.length];
        int outputPtr = 0;
        while(!minHeap.isEmpty()){
            int[] numFreq = minHeap.remove();
            for(int i = 0; i < numFreq[1]; i++){
                output[outputPtr] = numFreq[0];
                outputPtr++;
            }
        }

        return output;
    }
}