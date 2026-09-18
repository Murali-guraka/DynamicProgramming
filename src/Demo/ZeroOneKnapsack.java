package Demo;

public class ZeroOneKnapsack {
    
    static int knapsack(int[] weights, int[] values, int capacity) {
        
        int n = weights.length;
        
        // dp[i][w] stores the max value using the first 'i' items with capacity 'w'
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                
                // Check if the current item's weight can fit into the current capacity
                if (weights[i - 1] <= w) {
                    // Option 1: Take the item
                    int take = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                    // Option 2: Skip the item
                    int skip = dp[i - 1][w];
                    
                    // Choose the maximum of taking or skipping
                    dp[i][w] = Math.max(take, skip);
                } else {
                    // Item is too heavy; must skip it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // Return the maximum profit for all items and full capacity
        return dp[n][capacity];
    }
    public static void main(String[] args) {
		int[] weight= {1,3,4,5};
		int[] values= {1,4,5,7};
		int capacity=7;
		System.out.println("Maximum value ="+knapsack(weight,values,capacity));
	}
}