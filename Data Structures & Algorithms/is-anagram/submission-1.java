/**
T: O(n+m), where n and m are length of string s and t respectively 
S: O(1), there can be a max of 26 chars, relatively constant. 
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        // { }
        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)) return false;
            int occurenence = map.get(ch);
            if(occurenence == 1){
                map.remove(ch);
                continue;
            }
            map.put(ch, --occurenence);
        }

        return map.isEmpty();
    }
}
