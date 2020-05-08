package april2020;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 */

/**
 * This problem can be solved by realizing that we are going to sum profits over consecutive transactions
 * (Peak and Valley)
 * for example [7,1,5,3,6,4]:
 * from 1 to 5 profit = 4, from 3 to 6 profit = 3 i.e total profit = 7
 *
 * example 2: [1,2,3,4,5]
 * from 1 to 2 p = 1,
 * from 2 to 3 p = 1,
 * from 3 to 4 p = 1,
 * from 4 to 5 p = 1
 * Total profit =  4
 */
public class BestTimeToBuySell {
    static int maxProfit(int[] prices) {
        int max_profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) max_profit += prices[i] - prices[i-1];
        }
        return max_profit;
    }
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println("Max profit " + maxProfit(arr));
    }
}
