package baekjoon.bfs;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test1963 {

    static int start, end, ans;
    static int MAX = 10000;
    static Queue<Integer> q;
    static int[] dp;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        prime = new boolean[MAX];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i < MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            start = parseInt(s[0]);
            end = parseInt(s[1]);
            ans = -1;
            q = new LinkedList<>();
            dp = new int[10000];
            Arrays.fill(dp, MAX + 1);
            q.add(start);
            dp[start] = 0;
            while (!q.isEmpty()) {
                int now = q.poll();
                if (now == end) {
                    ans = dp[now];
                    break;
                }
                for (int i = 0; i <= 3; i++) {
                    for (int j = 0; j <= 9; j++) {
                        int next = now;
                        if (i == 0) {
                            next = j * 1000 + next % 1000;
                        } else if (i == 1) {
                            next = next / 1000 * 1000 + j * 100 + next % 100;
                        } else if (i == 2) {
                            next = next / 100 * 100 + j * 10 + next % 10;
                        } else {
                            next = next / 10 * 10 + j;
                        }
                        if (next >= 1000 && prime[next] && dp[next] > dp[now] + 1) {
                            dp[next] = dp[now] + 1;
                            q.add(next);
                        }
                    }
                }
            }
            bw.write(ans == -1 ? "IMPOSSIBLE\n" : dp[end] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
