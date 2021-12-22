package baekjoon.dijkstra;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test18352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = parseInt(s[0]);
        int m = parseInt(s[1]);
        int k = parseInt(s[2]);
        int x = parseInt(s[3]);
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dist, MAX_VALUE);
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            list[parseInt(s[0])].add(parseInt(s[1]));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (visit[now]) {
                continue;
            }
            visit[now] = true;
            for (int next : list[now]) {
                if (dist[next] >= dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        String ans = "";
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                ans += (i+"\n");
            }
        }
        if (ans.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

}
