class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {} # Dictionarz to store numbers and their indicies

        for i, num in enumerate(nums):
            complement = target - num # The value we need to find

            if complement in num_map:
                return [num_map[complement], i] #Return indicies if complement found
 
            num_map[num] = i # Store the number with its index
        
        return [] # No Solution found
        