class Solution :
    def minOperations(self, nums: list[int]) -> int:
        n = len(nums)
        operations = 0
        temp_nums = list(nums)
        
        for i in range (n - 2):
            if temp_nums[i] == 0:
                operations += 1
                temp_nums[i] ^= 1
                temp_nums[i + 1] ^= 1
                temp_nums[i + 2] ^= 1
                
        if temp_nums[n - 2] == 0 or temp_nums[n - 1] == 0:
            return -1
        
        return operations