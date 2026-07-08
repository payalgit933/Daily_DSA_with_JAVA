// You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].
// For each queries[i], extract the substring s[li..ri]. Then, perform the following:
// Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
// Let sum be the sum of digits in x. The answer is x * sum.
// Return an array of integers answer where answer[i] is the answer to the ith query. 
// Since the answers may be very large, return them modulo 109 + 7.

import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    class BIT {
        long[] bit;
        int n;

        BIT(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, long val) {
            idx++;
            while (idx <= n) {
                bit[idx] = (bit[idx] + val) % MOD;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            idx++;
            long res = 0;
            while (idx > 0) {
                res = (res + bit[idx]) % MOD;
                idx -= idx & -idx;
            }
            return res;
        }

        long query(int l, int r) {
            if (l > r) return 0;
            long ans = sum(r) - (l == 0 ? 0 : sum(l - 1));
            ans %= MOD;
            if (ans < 0) ans += MOD;
            return ans;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        int[] nzPrefix = new int[n + 1];
        int[] digitPrefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nzPrefix[i + 1] = nzPrefix[i];
            digitPrefix[i + 1] = digitPrefix[i];
            int d = s.charAt(i) - '0';
            if (d != 0) nzPrefix[i + 1]++;
            digitPrefix[i + 1] += d;
        }

        List<int[]>[] byLeft = new ArrayList[n];
        for (int i = 0; i < n; i++) byLeft[i] = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            byLeft[queries[i][0]].add(new int[]{queries[i][1], i});
        }

        BIT bit = new BIT(n);

        int totalNZ = 0;

        for (int i = n - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                bit.add(i, d * pow10[totalNZ] % MOD);
                totalNZ++;
            }

            for (int[] q : byLeft[i]) {
                int r = q[0];
                int idx = q[1];

                int cnt = nzPrefix[r + 1] - nzPrefix[i];
                long x = bit.query(i, r);

                int after = totalNZ - cnt;
                x = x * modInverse(pow10[after]) % MOD;

                long sum = digitPrefix[r + 1] - digitPrefix[i];
                queries[idx][0] = (int) (x * sum % MOD);
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = queries[i][0];

        return ans;
    }

    private long modPow(long a, long e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return res;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}
