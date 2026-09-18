package Demo;

public class HouseRobber {

    static int rob(int[] money) {
        int n = money.length;

        // Base cases
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return money[0];
        }

        // Initialize dynamic programming array
        int[] dp = new int[n];

        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        // Fill the dp array for the remaining houses
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], money[i] + dp[i - 2]);
        }

        // The last element contains the maximum stolen value
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("Maximum stolen money: " + rob(houses)); // Output: 12
    }
}