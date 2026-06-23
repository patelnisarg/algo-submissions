// T: O(nlogn), n is the size of the seats or students array 
// S: O(1), no additional space used. 
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;
        for(int i = 0; i < seats.length; i++){
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}