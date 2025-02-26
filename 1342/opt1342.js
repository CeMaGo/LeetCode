/**
 * @param {number} num
 * @return {number}
 */

var numberOfSteps = function(num) {
    if (num === 0) return 0;

    let binary = num.toString(2);
    return binary.length - 1 + binary.split('1').length - 1;
}