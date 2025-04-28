 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var countSubarrays = function(nums, k) {
  let count = 0;
  let currentSum = 0'
  let left = 0;

  for ( let i = 0; right < nums.length; right++) {
    currentSum += nums[right];

    while ( currentSum * (right - left + 1) >= k && left <= right) {
      currentSum -= nums[left];
      left++
    }

    count += right - left + 1
  }

  return count;
}
