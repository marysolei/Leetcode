class Solution {
    public int maxProfit(int[] prices) {
        
        //check for null input 
        if(prices == null || prices.length ==0)return 0;
        int totalProfit = 0;
      
        for(int i=0; i< prices.length-1; i++){
            if(prices[i+1] - prices[i]>0) totalProfit += prices[i+1]- prices[i];
        }
        return totalProfit;
    }
}

//Time complexity:O(n)
//Space complexity: O(1)