class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        count = 0
        for num in nums:
            num_str = str(num)
            if len(num_str) % 2 == 0:
                count += 1
        return count

