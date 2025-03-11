class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        def is_vowel(char):
            return char in 'aeiou'

        def has_all_vowels(substring):
            return all(vowel in substring for vowel in 'aeiou')

        n = len(word)
        count = 0

        for i in range(n):
            for j in range(i, n):
                substring = word[i:j + 1]
                if has_all_vowels(substring):
                    consonant_count = 0
                    for char in substring:
                        if not is_vowel(char):
                            consonant_count += 1
                    if consonant_count == k:
                        count += 1

        return count