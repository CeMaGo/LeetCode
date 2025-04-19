class Solution {
    public int minOperations(int[] nums) {
        int  n = nums.length;
        int operations = 0;
        int[] tempNums = nums.clone();

        for (int i = 0; i <= n - 3; i++) {
            if (tempNums[i] == 0) {
                operations++;

                tempNums[i] ^= 1;
                tempNums[ i + 1 ] ^= 1;
                tempNums[ i + 2] ^= 1;
            }
        }

        if (tempNums[n - 2] == 0 || tempNums[n - 1] == 0) {
            return -1;
        }

        return operations;

    }

}