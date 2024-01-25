class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //check for null input
        if(nums1 == null || nums2 == null) return null;
        HashSet<Integer> num1Set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int num: nums1) num1Set.add(num);
        for(int num: nums2) {
            if(num1Set.contains(num)) res.add(num);
        }
        int[] finalRes = new int[res.size()];
        int index =0;
        for (int num: res) finalRes[index++] = num;
        return finalRes;
    }
}
//Time complexity: O(n)