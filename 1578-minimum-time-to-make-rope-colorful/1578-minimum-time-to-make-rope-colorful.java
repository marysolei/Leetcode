class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        //check for null input 
        if(colors == null || neededTime == null)return 0;
        int res = 0;
        //from Hint1: Maintain the running sum and max value for repeated letters.
        int maxTime = 0;
        int sumTime = 0;
        for(int i=0; i< colors.length(); i++){
            if(i>0 && colors.charAt(i) != colors.charAt(i-1)){
                res += sumTime - maxTime;
                sumTime = 0;
                maxTime = 0;
            }
            sumTime += neededTime[i];
            maxTime = Math.max(maxTime, neededTime[i]);
        }
        res += sumTime - maxTime;
        return res;
    }
}
//Time complexity: O(n)
//Space Complexity: O(1)