/**
- at every point if we know the leftMax, rightMax we can caluculate how much of the water 
can be trapped at the current index 
- create a leftMax array and rightMax array and than use that to calculate
*/
class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int lMax = -1, rMax = -1;
        for(int i = 0; i < height.length; i++){
            lMax = Math.max(lMax, height[i]);
            leftMax[i] = lMax;
        }
        for(int i = height.length-1; i >= 0; i--){
            rMax = Math.max(rMax, height[i]);
            rightMax[i] = rMax;
        }
        int trappedWater = 0;
        for(int i = 0; i < height.length; i++){
            int currTrapped = Math.min(leftMax[i], rightMax[i]) - height[i];
            trappedWater += currTrapped;
        }

        return trappedWater;
    }
}
