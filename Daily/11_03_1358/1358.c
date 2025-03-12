// #include  <stdio.h>
// #include <string.h>

// int numberOfSubstrings(char *s) {
//     int n = strlen(s);
//     int left = 0, right = 0, count =0;
//     int counts[3] = {0};

//     while (right < n) {
//         counts[s[right] - 'a']++;

//         while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
//             count += n - right;
//             counts[s[left] - 'a']--;
//             left++;
//         }
//     right++;
// }
// return count;
// }
 
 #include <string.h>
 #include <limits.h>

 int numberOfSubstrings(char *s) {
    int abc[3] = {-1, -1, -1};
    int count = 0, right = 0;
    
    while (s[right] != '\0') {
        abc[s[right] - 'a'] = right;
        int minIndex = INT_MAX;
        for (int i = 0; i < 3; i++) {
            if ( abc[i] < minIndex) {
                minIndex = abc[i];
            }
        }
        count += (minIndex + 1);
        right++;
    }
    return count;
 }
