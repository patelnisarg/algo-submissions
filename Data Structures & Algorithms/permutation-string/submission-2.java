class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            s1Map.put(ch, s1Map.getOrDefault(ch, 0)+1);
        }
        int left = 0, right = 0;
        while(right < s2.length()){
            s2Map.put(s2.charAt(right), s2Map.getOrDefault(s2.charAt(right), 0) + 1);

            if((right-left+1) > s1.length()) {
                s2Map.put(s2.charAt(left), s2Map.get(s2.charAt(left))-1);
                if(s2Map.get(s2.charAt(left)) == 0){
                    s2Map.remove(s2.charAt(left));
                }
                left++;
            }
            if((right-left+1 == s1.length()) && compare(s1Map, s2Map)){
                return true;
            }
            right++;
        }
        return false;
    }

    private boolean compare(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map){
        if(s1Map.size() != s2Map.size()){
            return false;
        } 
        for(char ch : s1Map.keySet()){
            if(!s2Map.containsKey(ch)){
                return false;
            } else if(s2Map.get(ch) != s1Map.get(ch)){
                return false;
            }
        }
        return true;
    }
}
