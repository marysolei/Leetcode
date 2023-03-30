class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length ==0) return result;
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++){
            // Since nums[i] <= nums[left] <= nums[right], if nums[i] > 0 then sum=nums[i]+nums[left]+nums[right] > 0
            if(nums[i]>0) break;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+ nums[left]+ nums[right];
                if(sum >0) right--;
                else if(sum<0) left++;
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left+1<right && nums[left] == nums[left+1]) left++;//skip duplicate
                    left++;
                    right--;
                }
            }
            while(i+1 < nums.length && nums[i]== nums[i+1]) i++; //skip duplicate nums[i]
            
        }
        return result;
    }
}

/*Sort nums in increasing order.
Fix nums[i] by itearting i in [0..n-1]
Two pointers in range [i+1..n-1] to find nums[l] and nums[r] so that nums[i] + nums[l] + nums[r] = 0 But, remember to skip duplicate elements as well.*/