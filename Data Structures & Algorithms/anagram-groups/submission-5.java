// T: O(n*m), n is the size of strs arr and m is the max size of the string
// S: O(n), n is the number of distinct words
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        for(String str : strs){
            // assuming only lowercase chars
            int[] charFreq = new int[26]; 
            for(char ch : str.toCharArray()){
                charFreq[ch - 'a']++;
            }
            String freqStr = Arrays.toString(charFreq);
            map.computeIfAbsent(freqStr, k -> new ArrayList<>()).add(str);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            output.add(entry.getValue());
        }

        return output;
    }
}
