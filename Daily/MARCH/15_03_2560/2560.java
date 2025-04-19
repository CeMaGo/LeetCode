class Solution {
    public int minCapability(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        int ans = maxVal;
        int left = minVal;
        int right = maxVal;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canRob(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canRob(int[] nums, int k, int capability) {
        int count = 0;
        boolean robbedPrevious = false;
        for (int money : nums) {
            if (money <= capability && !robbedPrevious) {
                count++;
                robbedPrevious = true;
            } else {
                robbedPrevious = false;
            }
        }
        return count >= k;
    }
}