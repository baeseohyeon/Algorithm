package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class test10282 {
    static int MAX = MAX_VALUE;

    static class Node {
        int idx, time;

        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            int answer = 0, cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            int[] dist = new int[n + 1];
            boolean[] visit = new boolean[n + 1];
            List<Node>[] list = new ArrayList[n + 1];
            Arrays.fill(dist, MAX);
            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = parseInt(st.nextToken());
                int b = parseInt(st.nextToken());
                int s = parseInt(st.nextToken());
                list[b].add(new Node(a, s));
                if (b == c)
                    dist[a] = s;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return dist[o1] - dist[o2];
                }
            });
            pq.add(c);
            dist[c] = 0;
            while (!pq.isEmpty()) {
                int now = pq.poll();
                if (visit[now])
                    continue;
                visit[now] = true;
                cnt++;
                for (Node node : list[now]) {
                    int next = node.idx;
                    int time = node.time;
                    if (dist[next] >= dist[now] + time) {
                        dist[next] = dist[now] + time;
                        pq.add(next);
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                if (dist[i] == MAX)
                    continue;
                answer = Math.max(answer, dist[i]);
            }
            bw.write(cnt + " " + answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
