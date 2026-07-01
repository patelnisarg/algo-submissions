class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        // freq map of each char and its count from the tMap
        Map<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }
        int tUniqueChars = tMap.size();
        // freq map of each char and its count from the sMap
        Map<Character, Integer> sMap = new HashMap<>();
        int formed = 0;
        int left = 0, right = 0;
        int[] output = new int[2];
        boolean found = false;
        // loop through until we have all the distinct chars from t with the 
        // same freq in the current substring
        while(right < s.length()){
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right),0)+1);
            if(tMap.containsKey(s.charAt(right)) && (tMap.get(s.charAt(right)) == sMap.get(s.charAt(right)))){
                formed++;
            }
            while(formed == tUniqueChars){
                if(!found || (right - left) < (output[1] - output[0])){
                    output[0] = left;
                    output[1] = right;
                    found = true;
                }
                sMap.put(s.charAt(left), sMap.get(s.charAt(left))-1);
                if(tMap.containsKey(s.charAt(left)) && (sMap.get(s.charAt(left)) < tMap.get(s.charAt(left)))){
                    formed--;
                }
                if(sMap.get(s.charAt(left)) <= 0){
                    sMap.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }
        return found == false ? "" : s.substring(output[0], output[1]+1);
    }
}
