class Solution:
    def minOperations(self, grid: list[list[int]], x: int) -> int:
        nums = []
        for row in grid:
            for num in row:
                nums.append(num)
            
        n = len(nums)
        nums.sort()
        
        median = nums[n // 2]
        operations = 0
        
        for num in nums:
            diff = abs(num - median)
            if diff % x != 0:
                return -1
            operations += diff // x
            
        return operations