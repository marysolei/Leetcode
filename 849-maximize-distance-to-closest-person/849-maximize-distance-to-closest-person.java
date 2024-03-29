class Solution {
    public int maxDistToClosest(int[] seats) {
        
        //check for null input 
        if(seats == null || seats.length ==0)return 0;
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,n); 
        Arrays.fill(right,n);
        
        for(int i=0; i<n ; i++){
            if(seats[i] == 1) left[i]= 0;
            else if(i>0) left[i] = left[i-1]+1;
        }
        for(int i=n-1; i>= 0 ; i--){
            if(seats[i] == 1) right[i]= 0;
            else if(i<n-1) right[i] = right[i+1]+1;
        }
        int res =0;
        for(int i=0; i< n; i++){
            if(seats[i] ==0) {
                res = Math.max(res, Math.min(left[i], right[i]));
            }
        }
        return res;
    }
}
//Time and Space complexity: O(n) where n is the length of seats