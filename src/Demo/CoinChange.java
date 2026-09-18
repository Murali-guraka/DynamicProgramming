package Demo;

import java.util.*;

public class CoinChange {

    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        // Fill the array with a large value representing infinity
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Iteratively calculate the minimum coins for each amount up to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(
                        dp[i],
                        1 + dp[i - coin]
                    );
                }
            }
        }
        
        // Return the result, or -1 if the amount cannot be made
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
		int[] coins= {1,2,5};
		int amount=11;
		System.out.println("Minimum coins = "+coinChange(coins,amount));
	}
}