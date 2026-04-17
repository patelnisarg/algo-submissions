class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int leftPtr = 0, rightPtr = heights.length-1;
        while(leftPtr < rightPtr){
            int currArea = Math.min(heights[leftPtr], heights[rightPtr]) * (rightPtr-leftPtr);
            max = Math.max(currArea, max);
            if(heights[leftPtr] < heights[rightPtr]){
                leftPtr++;
            } else {
                rightPtr--;
            }
        }

        return max;
    }
}
