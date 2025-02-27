// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // iterate throu the array with a nested loop

//         for (int i = 1; i < nums.length; i ++) {
//             for (int j = i; j < nums.length; j++) {
//                 // checking if the sum of the current pair equals the target
//                 if (nums[j] + nums[j - 1] == target) {
//                     return new int[] {j, j - i}; // return indicies of the matching pair
//                 }

//             }
//         }
//         return new int[]{};
//     }
// }

//HashMap Solution

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //HashMap to store visited Numbers
        Map<Integer, Integer> numMap = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) {
            // Find the missing Value
            int complement = target - nums[i];

            // If complement exists in the map, return indices
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            // Store current number with its index
            numMap.put(nums[i], i);
        }
        
        return new int[]{}; // no solution found
    }
}