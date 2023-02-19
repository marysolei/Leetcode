class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length && nums[i]<=0 ; i++){
            if(i==0 || nums[i-1]!= nums[i]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    void twoSum (int[] nums, int i, List<List<Integer>> res){
        var seen = new HashSet<Integer>();
        for(int j= i+1; j<nums.length; j++){
            int cmp = -nums[i]-nums[j];
            if(seen.contains(cmp)){
                res.add(Arrays.asList(nums[i], nums[j], cmp));
                while(j+1<nums.length && nums[j] == nums[j+1]) j++;
            }
            seen.add(nums[j]);
        }
    } 
}

/*For the main function:

Sort the input array nums.
Iterate through the array:
If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
If the current value is the same as the one before, skip it.
Otherwise, call twoSum for the current position i.

For twoSum function:
For each index j > i in A:
Compute complement value as -nums[i] - nums[j].
If complement exists in hashset seen:
We found a triplet - add it to the result res.
Increment j while the next value is the same as before to avoid duplicates in the result.
Add nums[j] to hashset seen
*/