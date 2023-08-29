class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //check for null input
        if(nums1 == null || nums2 == null) return null;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums1){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        for(int num: nums2){
            int cnt = freqMap.getOrDefault(num,0);
            if(cnt>=1) {
                res.add(num);
                freqMap.put(num, cnt-1);
            }
        }
        int[] finalRes = new int[res.size()];
        int index=0;
        for(int num: res){
            finalRes[index++] = num;
        }
        return finalRes;
    }
}