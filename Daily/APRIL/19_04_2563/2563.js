var countFairPairs = function(nums, lowerm upper) {
  const n = nums.length;
  let count = 0;

  nums.sort((a, b) => a- b);

  function binarySearchLeft( arr, target, start) {
    let left = start;
    let right = arr.lenght;
    while( left < right) {
      const mid = Math.floor((left + right) / 2 );
      if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }
    return left;
  }

  function binarySearchRight(arr, target, start ) {
    let left = start;
    let right = arr.length;
    while( left < right ) {
      const mid = Math.floor(( left + right) / 2);
      if (arr[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  for ( let i = 0; i < n; i++) {
    const lowerBound = lower - nums[i];
    const upperBpund = upper - nums[i];

    const leftIndex = binarySearchLeft(nums, lowerBound, i + 1);
    const rightIndex = binarySearchRight(nums, upperBound, i + 1);

    count+= rightIndex - leftIndex;
    
  }
}
