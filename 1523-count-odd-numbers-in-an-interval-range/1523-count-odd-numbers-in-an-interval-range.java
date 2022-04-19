class Solution {
    public int countOdds(int low, int high) {
        
        //count of odd numbers is half of the numbers between low and high
        //if at least one of the low and high is odd then we should consider that too
        if(low%2 ==1 || high%2==1) {
            return (high-low)/2+1;
        }
        return (high-low)/2;
    }
}