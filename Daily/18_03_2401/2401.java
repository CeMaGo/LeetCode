class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int currentAnd = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {

            while ((currentAnd & nums[right]) != 0) {
                currentAnd ^= nums[left];
                left++;
            }

            currentAnd |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}