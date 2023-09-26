class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        //check for null input 
        if(nums1 == null || nums2 == null)return null;
        HashSet<Integer> hset1 = new HashSet<>();
         HashSet<Integer> preRes = new HashSet<>();
        for(int num : nums1)hset1.add(num);
        for(int num : nums2)if(hset1.contains(num)) preRes.add(num);
        int[] res = new int[preRes.size()];
        int index =0;
        for (int num: preRes) res[index++] = num;
        return res;
    }
}