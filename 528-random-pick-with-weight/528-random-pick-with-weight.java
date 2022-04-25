class Solution {
    
    int[] arr;
    int totalSum;
    
    public Solution(int[] w) {
        this.arr = new int[w.length];
        int prefixSum = 0;
        
        for(int i=0; i< w.length ; i++){
            prefixSum += w[i];
            this.arr[i] = prefixSum;
        } 
        this.totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        /*Linear version
        int i=0;
        for(; i< this.arr.length ; i++){
            if(target < this.arr[i]) return i;
        }
        return i-1; */
        //binary search
        int left = 0;
        int right = this.arr.length;
        while(left < right) {
            int mid = left+(right -left)/2;
            if(target> this.arr[mid]) left = mid+1;
            else right = mid;
        }
        return left;
    }
}

//Time complexity: O(n) for constructor and O(logn) for pickindex

/*Given a list of positive values, we are asked to randomly pick up a value based on the weight of each value. it is sampling with weight.The probability that a number got picked is proportional to the value of the number, with regards to the total sum of all numbers.
*/

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();*/

/*Given a list of positive values, we are asked to randomly pick up a value based on the weight of each value. To put it simple, the task is to do sampling with weight.
*/