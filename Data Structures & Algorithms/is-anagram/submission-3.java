class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> charCount = new HashMap<>();
        // loop through chars in s and update charCount 
        for(char ch : s.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
        }

        // loop through chars in t and check
        // if charCount contains the char decrement the count by 1 
            // if newCount == 0, remove it from charCount
        // else return false
        for(char ch : t.toCharArray()){
            if(!charCount.containsKey(ch)) return false;
            int charFreq = charCount.get(ch);
            if(--charFreq == 0){
                charCount.remove(ch);
            } else {
                charCount.put(ch, charFreq);
            }
        }

        // return true if charCount is empty
        return charCount.isEmpty();
    }
}
