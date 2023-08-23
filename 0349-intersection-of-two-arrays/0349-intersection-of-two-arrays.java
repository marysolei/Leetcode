class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null)return null;
        HashSet<Integer> num1Set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int num: nums1) num1Set.add(num);
        for(int num: nums2){
            if(num1Set.contains(num)){
                result.add(num);
            }
        }
       int[] res = new int[result.size()];
        int index=0;
        for(int num: result) {
            res[index++]= num;
        }
        return res;
    }
}