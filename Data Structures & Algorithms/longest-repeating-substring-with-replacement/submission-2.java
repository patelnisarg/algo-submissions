class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap();
        int res = 0, l = 0, maxF = 0;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxF = Math.max(maxF, map.get(ch));

            while((r-l+1)-maxF > k){
                char leftCh = s.charAt(l);
                map.put(leftCh, map.get(leftCh)-1);
                l++;
            }
            res = Math.max(res, (r-l+1));
        }
        return res;
    }
}
