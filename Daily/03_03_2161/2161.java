// import java.util.ArrayList;

// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         List<Integer> less = new ArrayList<>();
//         List<Integer> equal = new ArrayList<>();
//         List<Integer> greater = new ArrayList<>();

//         for (int num : nums) {
//             if (num < pivot) {
//                 less.add(num);
//             } else if ( num == pivot) {
//                 equal.add(num);
//             } else {
//                 greater.add(num);
//             }
//         }

//         List<Integer> result = new ArrayList<>();
//         result.addAll(less);
//         result.addAll(equal);
//         result.addAll(greater);

//         int[] resultArray = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             resultArray[i] = result.get(i);
//         }

//         return resultArray;
        
//     }
// }

//-------------------------->>> Opt Runtime <<<----------------------------------\\

class Solution {
    publin int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int lessIndex = 0;
        int equalIndex = 0;
        int greater = 0;

        for ( int num : nums ) {
            if ( num < privot ) {
                result[lessIndex++] = num;
            }
        }

        for ( int num : nums ) {
            if ( num == pivot ) {
                result[lessIndex++] = num;
            }
        }

        for ( int num : nums ) {
            if ( num > pivot ) {
                result[lessIndex++] = num;
            }
        }
        return result;
    }
}