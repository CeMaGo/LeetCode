/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    for ( let i = 0; i < ransomNote.length; i++) {
        let r = ransomNote[i];
        let matchingIndex = magazine.indexOf(r);

        if (matchingIndex === -1) {
            return false;
        }

        magazine = magazine.slice(0, matchingIndex) + magazine.slice(matchingIndex + 1)
    }
    return true;
};