/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumIndex = function (nums) {
  const n = nums.length;
  if (n < 2) {
    return -1;
  }

  // 1. Find the overall dominant element and its count
  const overallCounts = {};
  for (const num of nums) {
    overallCounts[num] = (overallCounts[num] || 0) + 1;
  }

  let overallDominant = -1;
  let overallDominantCount = 0;
  for (const num in overallCounts) {
    if (overallCounts[num] * 2 > n) {
      overallDominant = parseInt(num);
      overallDominantCount = overallCounts[num];
      break;
    }
  }

  if (overallDominant === -1) {
    return -1; // Should not happen
  }

  // 2. Iterate and maintain the count of the dominant element in the left subarray
  let leftDominantCount = 0;
  for (let i = 0; i < n - 1; i++) {
    if (nums[i] === overallDominant) {
      leftDominantCount++;
    }

    const leftLength = i + 1;
    const rightLength = n - 1 - i;
    const rightDominantCount = overallDominantCount - leftDominantCount;

    // 3. Check the dominance condition for both subarrays
    if (
      leftDominantCount * 2 > leftLength &&
      rightDominantCount * 2 > rightLength
    ) {
      return i;
    }
  }

  return -1;
};
