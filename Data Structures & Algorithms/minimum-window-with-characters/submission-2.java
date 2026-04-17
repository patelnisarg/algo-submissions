class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || t == "") return "";
        HashMap<Character, Integer> charT = new HashMap();
        for(char ch : t.toCharArray()){
            charT.put(ch, charT.getOrDefault(ch,0)+1);
        }
        int res = Integer.MAX_VALUE;
        int[] idx = new int[]{-1, -1};
        int need = charT.keySet().size(); // count of the distinct char in t
        int have = 0; // count of the char in the s window that matches the count of char in T 
        int left = 0, right = 0;
        HashMap<Character, Integer> charS = new HashMap();
        for(; right < s.length(); right++){
            char charRight = s.charAt(right);
            charS.put(charRight, charS.getOrDefault(charRight, 0)+1);
            if(charT.containsKey(charRight) && charS.get(charRight) == charT.get(charRight)){
                have++;
            }
            while(have == need){
                if((right-left+1) < res){
                    res = right-left+1;
                    idx[0]= left;
                    idx[1] = right;
                }

                char leftChar = s.charAt(left);
                charS.put(leftChar, charS.get(leftChar)-1);
                if(charT.containsKey(leftChar) && charS.get(leftChar) < charT.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(idx[0], idx[1]+1);
    }
}
