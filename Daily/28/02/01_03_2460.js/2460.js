/**
 * @param {number[]} nums
 * @return {number[]}
 */
function applyOperations(nums) {
  const n = nums.length;

  // Apply operations
  for (let i = 0; i < n - 1; i++) {
    if (nums[i] === nums[i + 1]) {
      nums[i] *= 2;
      nums[i + 1] = 0;
    }
  }

  // Shift zeros
  let insertPos = 0;
  for (let i = 0; i < n; i++) {
    if (nums[i] !== 0) {
      nums[insertPos++] = nums[i];
    }
  }
  while (insertPos < n) {
    nums[insertPos++] = 0;
  }

  return nums;
}
