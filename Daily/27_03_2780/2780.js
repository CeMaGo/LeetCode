/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumIndex = function (nums) {
  const n = nums.length;
  if (n < 2) {
    return -1;
  }

  const getDominant = (arr) => {
    if (arr.length === 0) {
      return null;
    }
    const counts = {};
    for (const num of arr) {
      counts[num] = (counts[num] || 0) + 1;
    }
    for (const num in counts) {
      if (counts[num] * 2 > arr.length) {
        return parseInt(num);
      }
    }
    return null;
  };

  const overallDominant = getDominant(nums);
  if (overallDominant === null) {
    return -1; // Should not happen based on the problem constraints
  }

  for (let i = 0; i < n - 1; i++) {
    const leftSubarray = nums.slice(0, i + 1);
    const rightSubarray = nums.slice(i + 1);

    const leftDominant = getDominant(leftSubarray);
    const rightDominant = getDominant(rightSubarray);

    if (leftDominant === overallDominant && rightDominant === overallDominant) {
      return i;
    }
  }

  return -1;
};
