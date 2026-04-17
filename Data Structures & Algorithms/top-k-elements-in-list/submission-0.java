class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap(); // number is the key, number of occurences is value 
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (a,b) -> b.getValue().compareTo(a.getValue()));

        int[] output = new int[k];
        for(int i = 0; i < k; i++){
            output[i] = list.get(i).getKey();
        }

        return output;
    }
}
