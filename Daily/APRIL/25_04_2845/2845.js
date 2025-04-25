/**
 * @param {number[]} nums
 * @param {number} modulo
 * @param {number} k
 * @return {number}
 */
var countInterestingSubarrays = function (nums, modulo, k) {
  let count = 0;
  let currentRem = 0;
  const remCount = new Map();
  remCount.set(0, 1); // base case: empty prefix

  for (let num of nums) {
    // Add to current remainder only if num % modulo === k
    if (num % modulo === k) {
      currentRem = (currentRem + 1) % modulo;
    }

    // Get the target prefix remainder that would satisfy the condition
    const targetRem = (currentRem - k + modulo) % modulo;

    // Add all subarrays ending at current index that satisfy the condition
    count += remCount.get(targetRem) || 0;

    // Update the remainder count map
    remCount.set(currentRem, (remCount.get(currentRem) || 0) + 1);
  }

  return count;
};
