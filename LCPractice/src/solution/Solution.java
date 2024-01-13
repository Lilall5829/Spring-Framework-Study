package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int of = 0;
        int cf = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i]<prices[i+1]){
                profit += (prices[i+1]-prices[i]);
            }
        }
        return profit;
    }
}