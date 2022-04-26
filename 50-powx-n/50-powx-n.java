class Solution {
    public double myPow(double x, int n) {
        
       long num = n;
        if(num<0) {
            num = -num;
            x = 1/x;
        }
        return helper(x,num);
    }
    public double helper(double x , long n){
        //check edge case 
        if(n == 0)return 1.0;
        //call func for half
        double half = helper(x,n/2);
        //base case
        if(n%2 ==0) return half * half;
        else return half * half * x;
    }
}

//Time and space complexity : O(logn) each time n is reduced by half
