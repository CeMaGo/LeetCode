class Solution:
    def numberOfSteps(self, num: int) -> int:
        if num == 0:
            return 0

        binary = bin(num)[2:]
        return len(binary) - 1 + binary.count('1')