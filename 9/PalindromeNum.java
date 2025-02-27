class Solution {
    public boolean isPalindrome(int x) {
        // Negative Numbers are not palindromes
        // Numbers ending in 0 ( except 0 itself) are also not palindromes
        if ( x <0 || ( x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while ( x > reversedHalf ) {
            reversedHalf = reversedHalf * 10 + x % 10 ; // Extract last digit and add to reversedHalf
            x /= 10; // Remove last digit from x 
        }

        // Compare first half and second half
        return x == reversedHalf || x == reversedHalf / 10;
        
    }
}


// class Solution {
//     public boolean isPalindrome(int x) {
//         String numStr = Integer.toString(x);
//         String reversed = new StringBuilder(numStr).reverse().toString();
//         return numStr.equals(reversed);
//     }
// }