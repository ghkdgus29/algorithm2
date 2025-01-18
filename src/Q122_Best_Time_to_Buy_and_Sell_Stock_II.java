public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int hold = prices[0];
		for (int price : prices) {
			if (price - hold > 0) {
				profit += price - hold;
			}
			hold = price;
		}
		return profit;
	}
}
