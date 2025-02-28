/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let start = 0;
    let end = 0;
    let maxLength = 0;
    const charSet = new Set();

    while (end < s.length) {
        if (!charSet.has(s[end])) {
            charSet.add(s[end]);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        } else {
            charSet.delete(s[start]);
            start++;
        }
    }
    return maxLength;
    
};