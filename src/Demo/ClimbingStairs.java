package Demo;

public class ClimbingStairs {
    
    public static int climbStairs(int n) {
        // Base case: If there are 2 or fewer stairs, the number of ways is n
        if (n <= 2) {
            return n;
        }
        
        // dp array to store the number of ways to reach each step
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        // Fill the array using the recurrence relation
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n)); // Output will be 3
    }
}