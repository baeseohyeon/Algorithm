package baekjoon.disjointset;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class test16562 {

    static int n, m, k;
    static int[] parents;
    static int[] prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        parents = new int[n + 1];
        prices = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            prices[i] = parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent == bParent) {
                continue;
            }
            if (prices[aParent] <= prices[bParent]) {
                parents[bParent] = aParent;
            } else {
                parents[aParent] = bParent;
            }
        }
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (set.add(findParent(i))) {
                ans += prices[parents[i]];
            }
        }
        System.out.println(ans > k ? "Oh no" : ans);
    }

    private static int findParent(int now) {
        if (now == parents[now]) {
            return now;
        }
        return parents[now] = findParent(parents[now]);
    }
}
