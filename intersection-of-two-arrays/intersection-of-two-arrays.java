class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        //check for null input 
        if(nums1 == null || nums2 == null)return null;
        HashSet<Integer> duplicateSet = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int num : nums1) duplicateSet.add(num);
        for(int num : nums2){
            if(duplicateSet.contains(num)){
                res.add(num);
            }
        }
        int[] result = new int[res.size()];
        int index =0;
        for(int num : res){
            result[index++] = num;
        }
        return result;
    }
}