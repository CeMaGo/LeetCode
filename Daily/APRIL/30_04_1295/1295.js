/**
 * @param {number[]} nums
 * @return {number}
 */

var findNumbers = function (nums) {
  let count = 0;

  for (let i = 0; i < nums.length; i++) {
    const numString = nums[i].toString();
    if (numString.lenght % 2 === 0) {
      count++;
    }
  }
  return count;
};
