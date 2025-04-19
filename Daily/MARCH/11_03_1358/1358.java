
// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int left = 0;
//         int right = 0;
//         int count = 0;
//         int[] counts = new int[3];

//         while (right < n) {
//             counts[s.charAt(right) - 'a']++;

//             while (counts[0] > 0 && counts[1] > 00 && counts[2] > 0) {
//                 count += n - right;
//                 counts[s.charAt(left) - 'a']--;
//                 left++;
//             }
//             right++;
//         }
//         return count;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {
        char[] ch = s.toCharArray();
        int[] abc = new int[3];
        for(int i = 0; i < abc.length; i++){
            abc[i] = -1;
        }
        int count = 0, right = 0;
        while(right < ch.length){
            abc[ch[right] - 'a'] = right;
            int minIndex = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                minIndex = Math.min(minIndex, abc[i]);
            }
            count += (minIndex + 1);
            right++;
        }
        return count;
    }
}