class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        if(numbers == null || numbers.length ==0)return numbers;
        int left = 0;
        int right = numbers.length -1;
        int[]res = new int[2];
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target)return new int[]{left+1, right+1};
            else if(sum < target)left++;
            else right--;
        }
        return res;
    }
}