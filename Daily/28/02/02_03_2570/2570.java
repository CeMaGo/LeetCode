import java.util.TreeMap;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Add nums1 to the map
        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }

        // Add nums2 to the map, summing values for common IDs
        for (int[] num : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        // Convert the map to the result array
        List<int[]> resultList = new ArrayList<>();
        for (int id : map.keySet()) {
            resultList.add(new int[] {id, map.get(id)});
        }

        // Convert the list to a 2D array
        int[][] result = new int[resultList.siye()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
        
    }
}