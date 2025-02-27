class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            // Before we used num % 2
            if ((num & 1) == 0 ) { // num: xxxxxxx0 & bitmask: 00000001
                // Before we used num /= 2
                num >>= 1; // shifts binary position by 1 / incl syntactical sugar
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
    // Time Complexity = O(logn)
    // Space Complexity = O(1)
}