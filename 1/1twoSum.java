class Solution {
    public int[] twoSum(int[] nums, int target) {
        // iterate throu the array with a nested loop

        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j < nums.length; j++) {
                // checking if the sum of the current pair equals the target
                if (nums[j] + nums[j - 1] == target) {
                    return new int[] {j, j - i}; // return indicies of the matching pair
                }

            }
        }
        return new int[]{};
    }
}