class Solution {
    public int largestUniqueNumber(int[] nums) {
        
        if(nums == null || nums.length == 0)return -1;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int res = -1;
        for(int num : nums) hmap.put(num, hmap.getOrDefault(num,0)+1);
        for(int key: hmap.keySet()){
            if(hmap.get(key) ==1) {
                res = Math.max(res,key);
            }
        }
        return res;
    }
}