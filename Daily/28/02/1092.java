class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // 1. Find LCS using dynamic programming
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 2. Construct the SCS
        int i = m;
        int j = n;
        StringBuilder result = new StringBuilder();

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (i > 0 && (j == 0 || dp[i - 1][j] >= dp[i][j - 1])) {
                result.insert(0, str1.charAt(i - 1));
                i--;
            } else {
                result.insert(0, str2.charAt(j - 1));
                j--;
            }
        }

        return result.toString();
    }
}