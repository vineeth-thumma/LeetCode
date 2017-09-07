public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len ==0) return 0;
        int max=prices[len-1], profit=0;
        
        for(int i=len-1; i>=0; i--) {
            max=Math.max(max,prices[i]);
            profit=Math.max(profit, max - prices[i]);
            
        }
        return profit;
        
    }
}