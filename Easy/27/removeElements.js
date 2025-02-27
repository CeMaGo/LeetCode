/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let k = 0; // Pointer for the position of non/val

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) { // check if curr element is not equal to val
            nums[k] = nums[i]; // Move the non/val element to the front
            k++;
        }
    }
    return k;
};