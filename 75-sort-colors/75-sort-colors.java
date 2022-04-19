class Solution {
    public void sortColors(int[] nums) {
        
        //check for null input 
        if(nums == null || nums.length == 0)return;
        //pointers
        int zeroPointer = 0;
        int twoPointer = nums.length-1;
        int curr =0;
        int tmp;
        while(curr <= twoPointer){
            if(nums[curr] == 0){
                //swap the p0 and the curr element
                tmp = nums[zeroPointer];
                nums[zeroPointer++] = nums[curr];
                nums[curr++] = tmp;
            }else if(nums[curr] ==2){
                tmp = nums[curr];
                nums[curr] = nums[twoPointer];
                nums[twoPointer--]= tmp;
            }else curr++;
        }
    }
}
/*From Leetcode:use three pointers to track the rightmost boundary of zeros, the leftmost boundary of tows and the current element under the consideration. move curr pointer along the array, if nums[curr] = 0 - swap it with nums[p0], if nums[curr] = 2 - swap it with nums[p2].

Algorithm
- Initialise the rightmost boundary of zeros : p0 = 0. During the algorithm execution nums[idx < p0] = 0.
- Initialise the leftmost boundary of twos : p2 = n - 1. During the algorithm execution nums[idx > p2] = 2.
- Initialise the index of current element to consider : curr = 0.

While curr <= p2 :
If nums[curr] = 0 : swap currth and p0th elements and move both pointers to the right.
If nums[curr] = 2 : swap currth and p2th elements. Move pointer p2 to the left.
If nums[curr] = 1 : move pointer curr to the right.*/

//Time Complexity: O(n)
//space Complexity: O(1)