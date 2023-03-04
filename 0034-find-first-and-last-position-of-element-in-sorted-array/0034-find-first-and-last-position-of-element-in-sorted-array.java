class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length ==0)return res;
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    public int findFirst(int[] nums, int target){
        int res = -1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= target){
                right = mid-1;
            }else{
                left = mid+1;
            }
            if(nums[mid] == target) res= mid;
        }
        return res;
    }
    public int findLast (int[] nums, int target){
        int res = -1;
        int left = 0; 
        int right = nums.length -1;
        while(left<= right){
            int mid = left+(right-left)/2;
            if(nums[mid] <= target){
                left = mid+1;
            }else{
                right = mid-1;
            }
            if(nums[mid] == target) res = mid;
        }
        return res;
    }
}

/*There must be two indices in the array.we can just simply apply binary search twice to find each index of the target element.*/
