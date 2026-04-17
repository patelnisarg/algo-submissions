class Solution {
    public int longestConsecutive(int[] nums) {
        // edge case: if nums is empty 
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }

        int longestSequence = 0;
        for(int num : set){
            int currentSequnce = 0;
            while(set.contains(num-1)){
                currentSequnce++;
                num = num - 1;
            }
            longestSequence = Math.max(longestSequence, currentSequnce);
         }

        return longestSequence+1;
    }
}

/**
- returning the len of the longest consequtive seq
- sequence - each number is exactly 1 greater than the previous element 
- elements do not have to be consecutive in original array 

- nums = [2,20,4,10,3,4,5]
return - 4

{2,20,4,10,3,5}
2 - 0
20 - 0
4 -> 3 -> 2 : 3
10 - 0
3 -> 2 : 1
5 -> 4 -> 3 -> 2: 4

- nums: [0,3,2,5,4,6,1,1]
{0,3,2,5,4,6,1}
0 : 0
3 -> 2 -> 1 -> 0 : 4
2 -> 1 -> 0 : 3
5 -> 4 -> 3 -> 2 -> 1 -> 0 : 6
4 -> 3 -> 2 -> 1 -> 0 : 5
6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0 : 7
1 -> 0 : 0
*/
