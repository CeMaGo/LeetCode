// int expandAroundCenter(char* s, int left, int right) {
//     while (left >= 0 && right < strlen(s) && s[left] == s[right]) {
//         left--;
//         right++;
//     }
//     return right - left - 1;
// }


// char* longestPalindrome(char* s) {
//     if (s == NULL || strlen(s) < 1) {
//         return "";
//     }
//     int start = 0, end = 0;
//     int len = strlen(s);

//     for (int i = 0; i < len; i++) {
//         int len1 = expandAroundCenter(s, i, i);
//         int len2 = expandAroundCenter(s, i, i + 1);
//         int maxLen = (len1 > len2) ? len1 : len2;
//         if (maxLen > end - start + 1) {
//             start = i - (maxLen - 1) / 2;
//             end = i + maxLen / 2;
//         }
//     }

//     char* result = (char*)malloc((end - start + 2) * sizeof(char));
//     strncpy(result, s + start, end - start + 1);
//     result[end - start + 1] = '\0';
//     return result;
// }


//---------------------------------->>> FAST VERSION <<<------------------------------------\\

int expandAroundCenter(char* s, int left, int right, int len) {
    while (left >= 0 && right < len && s[left] == s[right]) {
        left--;
        right++;
    }
    return right - left - 1;
}

char* longestPalindrome(char* s) {
    if (s == NULL || s[0] == '\0') {
        return "";
    }

    int len = strlen(s);
    int start = 0, end = 0;

    for (int i = 0; i < len; i++) {
        int len1 = expandAroundCenter(s, i, i, len);
        int len2 = expandAroundCenter(s, i, i + 1, len);
        int maxLen = (len1 > len2) ? len1 : len2;

        if (maxLen > end - start + 1) {
            start = i - (maxLen - 1) / 2;
            end = i + maxLen / 2;
        }
    }

    char* result = (char*)malloc((end - start + 2) * sizeof(char));
    strncpy(result, s + start, end - start + 1);
    result[end - start + 1] = '\0';

    return result;
}

