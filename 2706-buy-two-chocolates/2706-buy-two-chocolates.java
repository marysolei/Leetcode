class Solution {
    public int buyChoco(int[] prices, int money) {
        if(prices == null || prices.length ==0)return money;
        Arrays.sort(prices);
        if(prices[0] + prices[1]<= money) return money- prices[0] - prices[1];
            else return money;
    }
}
//time complexity: O(nlogn) for sorting array