class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        Array.sort(strs);

        String first = strs[0], last = strs[strs.length - 1];
        int i = 0;

        while (i < first.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);

    }
}