package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test15591 {

    static int n, q;
    static List<Node>[] list;

    static class Node {

        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        q = parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < q; j++) {
            st = new StringTokenizer(br.readLine());
            int k = parseInt(st.nextToken());
            int video = parseInt(st.nextToken());
            sb.append(bfs(k, video) + "\n");
        }
        System.out.println(sb);
    }


    private static int bfs(int k, int video) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(video);
        visit[video] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node node : list[now]) {
                int next = node.v;
                int w = node.w;
                if (!visit[next] && w >= k) {
                    cnt++;
                    q.add(next);
                    visit[next] = true;
                }
            }
        }
        return cnt;
    }
}
