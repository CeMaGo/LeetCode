// /**
//  * @param {string} ransomNote
//  * @param {string} magazine
//  * @return {boolean}
//  */
// var canConstruct = function(ransomNote, magazine) {
//     for ( let i = 0; i < ransomNote.length; i++) {
//         let r = ransomNote[i];
//         let matchingIndex = magazine.indexOf(r);

//         if (matchingIndex === -1) {
//             return false;
//         }

//         magazine = magazine.slice(0, matchingIndex) + magazine.slice(matchingIndex + 1)
//     }
//     return true;
// };

/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    let charCount = {};

    for (let char of magazine ){
        charCount[char] = (charCount[char] || 0) +1;
    }

    for (let char of ransomNote) {
        if (!charCount[char] || charCount[char] === 0) {
            return false;
        }
        charCount[char]--;
    }
    return true;
}