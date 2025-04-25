/**
 * @param {number} n
 * @return {number}
 */

var countLargestGroup = function (n) {
  const sumDigitCounts = new Map();
  let maxSize = 0;

  for (let i = 1; i <= n; i++) {
    let num = i;
    let sumDigits = 0;

    while (num > 0) {
      sumDigits += num % 10;
      num = Math.floor(num / 10);
    }

    const currentCount = (sumDigitCounts.get(sumDigits) || 0) + 1;
    sumDigitCounts.set(sumDigits, currentCount);
    maxSize = Math.max(maxSize, currentCount);
  }

  let largestGroupCount = 0;
  for (const count of sumDigitCounts.values()) {
    if (count === maxSize) {
      largestGroupCount++;
    }
  }

  return largestGroupCount;
};
