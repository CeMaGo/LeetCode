class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = word.substring(i, j + 1);
                if (hasAllVowels(substring) && countConsonants(substring) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean hasAllVowels(String str) {
        String vowels = "aeiou";
        for (char vowel : vowels.toCharArray()) {
            if (str.indexOf(vowel) == -1) {
                return false;
            }
        }
        return true;
    }

    private int countConsonants(String str) {
        String vowels = "aeiou";
        int count = 0;
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) == -1 && Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }
}