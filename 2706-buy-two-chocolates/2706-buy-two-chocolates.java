class Solution {
    public int buyChoco(int[] prices, int money) {
        int min = Math.min(prices[0], prices[1]);
        int nextMin = Math.max(prices[0], prices[1]);
        for(int i=2; i< prices.length; i++){
            if (prices[i]< min){
                nextMin = min;
                min = prices[i];
            }else if (prices[i]< nextMin){
                nextMin = prices[i];
            }
        }
        int minCost = min + nextMin;
        if(minCost<=money) return money-minCost;
        return money;
    }
}

//time complexity: O(n)
//space complexity:O(1)