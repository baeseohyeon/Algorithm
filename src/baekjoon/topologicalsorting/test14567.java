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

public class test14567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int[] remain = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            remain[b]++;
            list[a].add(b);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (remain[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[n + 1];
        for (int i = 1; !q.isEmpty(); i++) {
            int size = q.size();
            while (size-- > 0) {
                int now = q.poll();
                dp[now] = i;
                for (int next : list[now]) {
                    remain[next]--;
                    if (remain[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i] + " ");
        }
        System.out.println(sb);
    }
}
