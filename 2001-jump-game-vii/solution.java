class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
       int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // add new possible position
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            // remove out of range position
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            // if any valid previous index exists
            if (reachable > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1]; 
    }
}
