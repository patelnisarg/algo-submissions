class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        if(temperatures.length == 0 || temperatures.length == 1) return output;

        Deque<Integer> temps = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++){
            int currTemp = temperatures[i];
            // need to think about consecutive duplicates 
            if(temps.isEmpty() || temperatures[temps.peekFirst()] >= currTemp){
                temps.addFirst(i);
            } else {
                while(!temps.isEmpty() && currTemp > temperatures[temps.peekFirst()]){
                    output[temps.peekFirst()] = i - temps.removeFirst();
                }
                temps.addFirst(i);
            }
        }

        return output;
    }
}
