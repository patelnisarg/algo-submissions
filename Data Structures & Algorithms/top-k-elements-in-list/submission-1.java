class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap(); // number is the key, number of occurences is value 
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = 
            new PriorityQueue<>((a,b) -> a.getValue().compareTo(b.getValue())); // min-heap
        for(Map.Entry<Integer, Integer> freq : map.entrySet()){
            queue.offer(freq);
            if(queue.size() > k){
                queue.poll();
            }
        }

        int[] output = new int[k];
        for(int i = 0; i < k; i++){
            output[i] = queue.poll().getKey();
        }

        return output;
    }
}
