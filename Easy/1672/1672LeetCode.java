class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = 0;

        for (int[] customer : accounts) {
            int currentCostumerWealth = 0;

            for (int bank : customer) {
                currentCostumerWealth += bank;
            }
            maxWealthSoFar = Math.max(maxWealthSoFar, currentCostumerWealth);
        }
        return maxWealthSoFar;
    }
}