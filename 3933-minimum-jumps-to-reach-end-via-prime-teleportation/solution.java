class Solution {
    public int minJumps(int[] nums) {
      int n = nums.length;

        if (n == 1) return 0;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Smallest Prime Factor
        int[] spf = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {

                for (int j = i; j <= max; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        // prime -> indices divisible by prime
        Map<Integer, List<Integer>> primeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            while (val > 1) {

                int p = spf[val];

                primeMap
                    .computeIfAbsent(p, k -> new ArrayList<>())
                    .add(i);

                // remove duplicates
                while (val % p == 0) {
                    val /= p;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return jumps;
                }

                // left
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // right
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                // teleport
                int val = nums[i];

                // only if prime
                if (val > 1 && spf[val] == val) {

                    List<Integer> next = primeMap.get(val);

                    if (next != null) {

                        for (int idx : next) {

                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }

                        // avoid repeated processing
                        primeMap.remove(val);
                    }
                }
            }

            jumps++;
        }

        return -1;   
    }
}
