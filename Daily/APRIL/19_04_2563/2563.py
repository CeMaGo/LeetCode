from bisect import bisect_left, bisect_right


class Solution: 
    def countFairPairs(self, nums: list[int], lower: int, upper:int ) -> int:
        n = len(nums)
        count = 0
        nums.sort()

        for i in range(n):
            lower_bound = lower - nums[i]
            upper_bound = upper - nums[i]

            left_index = bisect_left(nums, lower_bound, i + 1)
            right_index = bisect_right(nums, upper_bound, i + 1)

            count += right_index - left_index

        return count 


