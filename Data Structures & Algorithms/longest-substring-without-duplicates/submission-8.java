class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSeen = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while(right < s.length()){
            if(charSeen.contains(s.charAt(right))){
                while(left < right && charSeen.contains(s.charAt(right))){
                    charSeen.remove(s.charAt(left));
                    left++;
                }
            }
            charSeen.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
