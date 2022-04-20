class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        for(int i=0; i< nums.length; i++){
            sum+= nums[i];
            if(hmap.containsKey(sum-k)){
                res+= hmap.get(sum-k);
            }
            hmap.put(sum, hmap.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)

/*From Leetcode: 
If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i]−sum[j]=k, the sum of elements lying between indices i and j is k.
Based on these thoughts, we make use of a hashmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs.
We traverse over the array nums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum−k has occurred already, since it will determine the number of times a subarray with sum k has occurred up to the current index. We increment the res by the same amount*/