class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || t == "") return "";
        HashMap<Character, Integer> charT = new HashMap();
        for(char ch : t.toCharArray()){
            charT.put(ch, charT.getOrDefault(ch,0)+1);
        }
        int res = Integer.MAX_VALUE;
        int[] idx = new int[]{-1, -1};
        for(int l = 0; l < s.length(); l++){
            HashMap<Character, Integer> charS = new HashMap();
            boolean nextChar = false;
            for(int r = l; r < s.length(); r++){
                if(nextChar){break;}
                char currCh = s.charAt(r);
                charS.put(currCh, charS.getOrDefault(currCh, 0)+1);

                boolean flag = true;
                for(char ch : charT.keySet()){
                    if(charS.getOrDefault(ch, 0) < charT.get(ch)){
                        flag = false;
                        break;
                    }
                }
                if(flag && (r-l+1) < res){
                    res = r - l + 1;
                    idx[0] = l;
                    idx[1] = r;
                    nextChar = true;
                }
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(idx[0], idx[1]+1);
    }
}
