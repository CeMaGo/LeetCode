class Solution {
    public long repairCars(int[] ranks, int cars) {
      Array.sort(ranks);
      long left = 0;
      long right = (long) ranks[0] * cars * cars;
      long ans = right;

      while(left <= right) {
        long mid = left + (right - left) / 2;
        long totalCarsRepaired = 0;
        for (int rank : ranks) {
            totalCarsRepaired += (long) Math.sqrt((double) mid / rank);
        }

        if (totalCarsRepaired >= cars) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
        return ans;
      
}}