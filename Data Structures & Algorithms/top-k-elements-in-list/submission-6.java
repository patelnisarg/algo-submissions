// T: O(n+logn), where n is the size of nums array 
// S: O(n), n is the size of nums array in the case all num are distinct. 
class Pair {
    int num;
    int freq;

    public Pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // sort based on freq
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        HashMap<Integer, Integer> numFreq = new HashMap<>(); // key -> num, value -> freq
        for(int num : nums){
            numFreq.put(num, numFreq.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : numFreq.entrySet()){
            Pair newPair = new Pair(entry.getKey(), entry.getValue());
            queue.add(newPair);
        }

        int[] output = new int[k];
        for(int i = 0; i < k; i++){
            output[i] = queue.poll().num;
        }

        return output;
    }
}
