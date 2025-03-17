/**
 * @param {number[]} ranks
 * @param {number} cars
 * @return {number}
 */
var repairCars = function (ranks, cars) {
  ranks.sort((a, b) => a - b);
  let left = 0;
  let right = ranks[0] * cars * cars;
  let ans = right;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    let count = 0;
    for (const rank of ranks) {
      count += Math.floor(Math.sqrt(mid / rank));
    }

    if (count >= cars) {
      ans = mid;
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return ans;
};
