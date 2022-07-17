/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        if(n == 0)return 0;
        int left = 0;
        int right = n;
        int res = 0;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)) {
                res = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return res;
    }
}