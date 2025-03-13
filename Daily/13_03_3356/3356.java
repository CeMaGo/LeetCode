class Solution {
    public int minZeroArray(int[] nums, int[][] queries){
        int n = queries.length;
        for(int k = 1; k <= n; k++) {
            int[] temp = nums.clone();
            for ( k > 0) {

                for(int i = 0; i < k; i++) {
                    int l = queries[i][0];
                    int r = queries[i][1];
                    int val = queries[i][2];
                    for(int j = l; j <= r; j++) {
                        temp[j] = Math.max(0, temp[j] - val);
            }
                }
            }
            if (isZeroArray(temp)) {
                return k;
            }
        }
        return -1;
    }

    private boolean isZeroArray(int[] arr) {
        for (int num :arr ) {
            if ( num != 0) {
                return false;
            }
        }
        return true;
    }
}