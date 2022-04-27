class Solution {
    public int maxLength(int[] ribbons, int k) {
        
         int low = 1;
        int high = 100000;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCutPossible(ribbons, mid, k)) {
                ans = mid;
                low = mid + 1;            
            }
            else 
                high = mid - 1;
        }
        return ans;
    }
    public boolean isCutPossible(int[] ribbons, int size, int k){
         int numCuts = 0;
        for (int ribbon: ribbons) {
            numCuts += ribbon / size;
        }
        return numCuts >= k;
    }
}