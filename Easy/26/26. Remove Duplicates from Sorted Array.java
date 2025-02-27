class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Pointer for unique position

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { // found a unique element
                i++;
                nums[i] = nums[j]; // Move the unique element
            }
        }
        return i + 1; // Number of unique elements
    }
}