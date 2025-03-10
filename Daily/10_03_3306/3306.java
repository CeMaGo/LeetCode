import java.util.List;

class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        List<Integer> vowelPositions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i))) {
                vowelPositions.add(i);
            }
        }

        int count = 0;
        if (vowelPositions.size() < 5) return 0;

        for (int a = 0; a < vowelPositions.size(); a++) {
            for (int e = 0; e < vowelPositions.size(); e++){
                for (int i = 0; i < vowelPositions.size(); i++) {
                    for (int o = 0; o < vowelPositions.size(); o++) {
                        for (int u = 0; u < vowelPositions.size(); u++) {
                            int[] indices = {vowelPositions.get(a),
                                             vowelPositions.get(e),
                                             vowelPositions.get(i),
                                             vowelPositions.get(o),
                                             vowelPositions.get(u)
                                            };
                                            java.util.Arrays.sort(indices);
                                            int left = indices[0];
                                            int right = indices[4];

                                            int consonantCount = 0;
                                            for (int idx = left; idx <= right; idx++) {
                                                if ( !isVowel(word.charAt(idx))) {
                                                    consonantCount++;
                                                }
                                            }
                                            if ( consonantCount == k) {
                                                count++;
                                            }
                        }
                    }
                }
            }
            return count;
        }
        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c = 'o' || c = 'u';
        }
    }
}