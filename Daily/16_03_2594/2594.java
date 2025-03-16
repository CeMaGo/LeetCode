class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 0;
        long right = (long) ranks[0] * cars * cars;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if ( canFinish(ranks, cars, mid)) {
                ans = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean canFinish(int[] ranks, int cars, long time) {
       long totalCarsRepaired = 0;
       for ( int rank : ranks) {
           totalCarsRepaired += (long) Math.sqrt((double) time / rank);
       }
       return totalCarsRepaired >= cars;
    }

}