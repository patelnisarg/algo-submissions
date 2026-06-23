/**
- its a one way highway 
- each car may start at different position with different speed 
- we need to calculate how many fleets (aka groups) of cars will reach at the destination together 
- a group is: # of cars that will reach together 
- each car cannot pass another car infront of them -> IMP 
*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort it based on the position of the car
        // since the car that start closer to the destination 
        // will be ahead of the cars far from the destination
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        Deque<Double> timeTaken = new ArrayDeque<>();
        
        for(int i = 0; i < cars.length; i++){
            int carPosition = cars[i][0];
            int carSpeed = cars[i][1];
            double totalTime = ((double)(target - carPosition) / carSpeed);
            // System.out.println("car position: " + carPosition + " time take: " + totalTime);
            
            if(timeTaken.size() == 0 || timeTaken.peekFirst() < totalTime){
                timeTaken.addFirst(totalTime);
            }
        }

        return timeTaken.size();
    }
}
