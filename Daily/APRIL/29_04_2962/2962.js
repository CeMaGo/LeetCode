/**
 * @param {numberp[]} nums
 * @param {number} k
 * @return {number}
 */

var countSubarrays = function (nums, k) {
  const n = nums.length;
  let count = 0;

  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      let maxVal = -1;
      let maxCount = 0;

      for (let x = i; x <= j; x++) {
        if (nums[x] > maxVal) {
          maxVal = nums[x];
          maxCount = 1;
        } else if (nums[x] === maxVal) {
          maxCount++;
        }
      }

      if (maxCount >= k) {
        count++;
      }
    }
  }
  return count;
};
