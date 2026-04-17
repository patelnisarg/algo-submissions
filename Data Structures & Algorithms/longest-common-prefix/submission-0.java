/**
- key to the problem is noticing that the prefix is either going to be the same or shrink 
- time complexity: O(n+m) - where n is the length of the shortest string and m is the number of string
- space: O(1) - no extra space used 
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while(j < Math.min(prefix.length(), strs[i].length())){
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j); // j is exclusive 
        }

        return prefix;
    }
} 