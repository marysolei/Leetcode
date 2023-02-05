class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 =0, p2=0, index=0;
        
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1] < nums2[p2]){
                p1++;
            }else if (nums1[p1] > nums2[p2]){
                p2++;
            }else {
                nums1[index++] = nums1[p1++];
                p2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}

//Time complexity: O(nlogn+ mlogm)
//space complxeity: O(n+m)