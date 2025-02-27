# class Solution:
#     def canConstruct(self, ransomNote: str, magazine: str) -> bool:
#         for char in ransomNote:
#             index = magazine.find(char)
#             if index == -1:
#                 return False
#             magazine = magazine[:index] + magazine[index +1 :]
#         return True
        
        
        
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        char_count = {} #Dictionary (hash Map) to Store letter frequencies

        #Count of each letter in magazine
        for char in magazine:
            char_count[char] = char_count.get(char, 0) + 1

        #Can ransomNote be constructet ?
        for char in ransomNote:
            if char_count.get(char, 0) == 0:
                return False #Not enough letters..
            char_count[char] -= 1 #Use one occurence
        
        return True