class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int left = 0, right = heights.length-1;
        
        while(left < right){
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            area = Math.max(area, currArea);
            if(heights[left] <= heights[right]){
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}
