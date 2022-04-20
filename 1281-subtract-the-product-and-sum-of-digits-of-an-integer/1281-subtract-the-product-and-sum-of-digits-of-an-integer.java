class Solution {
    public int subtractProductAndSum(int n) {
        
        if(n ==0)return 0;
        int sum = 0, product =1;
        while(n>0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return product-sum;
    }
}
//Time complexity : O(logn) we are dividing n by 10 each time
//Space complexity: O(1)