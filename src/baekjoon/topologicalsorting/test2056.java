package baekjoon.topologicalsorting;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test2056 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] times = new int[n + 1];
        int[] pre = new int[n + 1];
        List<Integer>[] listArr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            listArr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = parseInt(st.nextToken());
            int cnt = parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int num = parseInt(st.nextToken());
                pre[i]++;
                listArr[num].add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dp[i] = times[i];
            if (pre[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : listArr[now]) {
                pre[next]--;
                dp[next] = Math.max(dp[next], dp[now] + times[next]);
                if (pre[next] == 0) {
                    q.add(next);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
