class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> hashSet = new HashSet();
        for(char ch : s.toCharArray()){
            hashSet.add(ch);
        }
        int maxLen = 0;
        for(char ch : hashSet){
            int count = 0;
            int l = 0;
            for(int r = 0; r < s.length(); r++){
                char currCh = s.charAt(r);
                if(currCh == ch){
                    count++;
                }
                // len of the string - count (count of the same char)
                while((r-l+1)-count > k){
                    if(s.charAt(l) == ch){
                        count--;
                    }
                    l++;
                }
                maxLen = Math.max(maxLen, r-l+1);
            }
        }

        return maxLen;
    }
}
