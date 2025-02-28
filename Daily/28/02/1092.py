class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
         m = len(str1)
         n = len(str2)
         
         dp = [[0] * (n + 1) for _ in range(m + 1)]
         
         for i in range( 1, m + 1):
             for j in range( 1, n + 1):
                 if str1[i - 1] == str2[j - 1]:
                     dp[i][j] = dp[i -1][j -1] + 1
                 else:
                     dp[i][j] = max(dp[i - 1][j],dp[i][j - 1])
                     
         i = m 
         j = n
         result = ""
         
         while i > 0 or j > 0:
             if i > 0 and j > 0 and str1[i -1] == str2[j -1]:
                 result = str1[i - 1] + result
                 i -= 1
                 j -= 1
             elif i > 0 and (j == 0 or dp[i -1][j] > dp[i][j -1]):
                 result = str1[i - 1] + result
                 i -= 1
             else:
                 result = str2[j -1 ] + result
                 j -= 1
         return result 