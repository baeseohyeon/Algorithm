package baekjoon.dfs;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16947 {

    static int n, start;
    static int[] ans;
    static boolean isCycle, checkStart;
    static boolean[] visit;
    static List<Integer> tmp, cycle;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = parseInt(br.readLine());
        ans = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        tmp = new ArrayList<>();
        cycle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        findCycle(1, 1);
        Arrays.fill(ans, MAX_VALUE);
        for (int i : cycle) {
            ans[i] = 0;
            bfs(i);
        }
        for (int i = 1; i <= n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void findCycle(int now, int prev) {
        if (isCycle) {
            return;
        }
        visit[now] = true;
        for (int next : list[now]) {
            if (visit[next] && next != prev && !isCycle) {
                isCycle = true;
                start = next;
            }
            if (!visit[next]) {
                findCycle(next, now);
            }
        }
        if (isCycle && !checkStart) {
            cycle.add(now);
        }
        if (now == start) {
            checkStart = true;
        }
    }

    private static void bfs(int now) {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[n + 1];
        q.add(new int[]{now, 0});
        visit[now] = true;
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int cnt = arr[1];
            now = arr[0];
            for (int next : list[now]) {
                if (cycle.contains(next)) {
                    continue;
                }
                ans[next] = Math.min(ans[next], cnt + 1);
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
    }
}
