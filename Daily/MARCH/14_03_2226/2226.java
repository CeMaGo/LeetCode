class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }

        long left = 0;
        long right = maxCandy;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible (candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
        
    }

    private boolean isPossible(int[] candies, long k, long target) {
        if ( target == 0) {
            return true;
        }
        long children = 0;
        for (int candy : candies) {
            children += candy / target;
        }
        return children >= k;
    }
}