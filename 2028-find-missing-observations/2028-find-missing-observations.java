class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rollSum = 0;
        for(int num: rolls) rollSum += num;
        int totalSum = mean *(n+rolls.length);
        int diff = totalSum - rollSum;
        int div = diff/n;
        int rem = diff%n;
        if(div ==0 || diff<0 || n*6<totalSum-rollSum) return new int[]{};
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i]= div;
            if(rem>0){
                res[i]++;
                rem--;
            }
        }
       return res; 
    }
}