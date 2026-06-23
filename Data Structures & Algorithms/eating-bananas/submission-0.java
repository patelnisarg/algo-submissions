class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }
        int res = right;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            // calculate hours to eat all piles with mid hours 
            int timeTaken = 0;
            for(int i = 0; i < piles.length; i++){
                float p = (float)piles[i];
                timeTaken += (int) Math.ceil((double) piles[i] / mid);
            }
            if(timeTaken > h){
                left = mid+1;
            } else {
                res = mid;
                right = mid-1;
            }
        }

        return res;
    }
}
