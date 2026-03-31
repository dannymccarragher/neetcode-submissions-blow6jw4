class Solution {
    public int maxProfit(int[] prices) {
        // buy low - sell high
        // keep track of minimum and maxProfit. if we never find a profit (ex: > 1)
        // we will return 0

        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < buy){
                buy = prices[i];
            }

            if(prices[i] - buy > maxProfit){
                maxProfit = prices[i] - buy;
            }
        }

        return maxProfit; 
    }
}
