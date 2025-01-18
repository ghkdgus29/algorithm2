public class Q121_Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int minVal = Integer.MAX_VALUE;
		for(int price: prices) {
			minVal = Math.min(minVal, price);
			profit = Math.max(profit, price - minVal);
		}
		return profit;
	}
}
