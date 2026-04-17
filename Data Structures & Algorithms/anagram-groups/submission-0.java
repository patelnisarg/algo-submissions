class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String str : strs){
            int[] count = new int[26]; // 26 alphabets, all smallercase
            for(char ch : str.toCharArray()){
                count[ch - 'a']++;
            }
            String occourCount = Arrays.toString(count);
            map.putIfAbsent(Arrays.toString(count), new ArrayList());
            map.get(occourCount).add(str);
        }
        List<List<String>> output = new ArrayList();
        for(List<String> anagrams : map.values()){
            output.add(anagrams);
        }

        return output;
    }
}
