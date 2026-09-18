package Demo;

public class LongestCommonSubSequence {

    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // dp table initialized to 0 by default in Java
        int[][] dp = new int[n + 1][m + 1];
        
        // Loop through both strings
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                // If characters match
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                // If characters do not match
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The bottom-right corner holds the length of the LCS
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("Length of LCS: " + lcs(s1, s2)); // Output: 3 ("ADH")
    }
}