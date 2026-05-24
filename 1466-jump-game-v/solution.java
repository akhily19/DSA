class Solution {
    public int maxJumps(int[] arr, int d) {
         int n = arr.length;

        Integer[] memo = new Integer[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(arr, d, i, memo));
        }

        return ans;
    }

    private int solve(int[] arr, int d, int i, Integer[] memo) {

        if (memo[i] != null) {
            return memo[i];
        }

        int max = 1;

        // right
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {

            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + solve(arr, d, j, memo));
        }

        // left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + solve(arr, d, j, memo));
        }

        memo[i] = max;

        return max;
    }
}
