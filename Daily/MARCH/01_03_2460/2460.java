class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Shift zeros
        int insertPos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        while (insertPos < n) {
            nums[insertPos++] = 0;
        }

        return nums;
    }
}