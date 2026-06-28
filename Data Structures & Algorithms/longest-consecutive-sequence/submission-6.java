class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums){
            numsSet.add(num);
        }

        int seq = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(numsSet.contains(curr - 1)){
                continue;
            } else {
                int currSeq = 1;
                while(numsSet.contains(curr+1)){
                    currSeq++;
                    curr = curr+1;
                }
                seq = Math.max(seq, currSeq);
            }
        }

        return seq;
    }
}
