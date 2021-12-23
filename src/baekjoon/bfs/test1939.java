package baekjoon.bfs;


import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1939 {

    static class Node {

        int next, dist;

        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    static int n, m;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int s = parseInt(st.nextToken());
        int e = parseInt(st.nextToken());
        int left = 0, right = MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(s, e, mid)) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean bfs(int s, int e, int mid) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        q.add(s);
        visit[s] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == e) {
                return true;
            }
            for (Node node : list[now]) {
                int dist = node.dist;
                int next = node.next;
                if (dist >= mid && !visit[next]) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }

}
