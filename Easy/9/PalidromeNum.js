/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    let arr = String(x).split("");
    return arr.join("") === arr.reverse().join("");
};