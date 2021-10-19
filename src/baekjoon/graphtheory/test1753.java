package baekjoon.graphtheory;

import java.io.*;

import java.util.*;

import static java.lang.Integer.*;

public class test1753 {

    static int MAX = 100000;

    static class Vertex {
        int v;
        int w;

        Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = parseInt(st.nextToken());
        int e = parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        List<Vertex>[] list = new ArrayList[v + 1];
        int[] dist = new int[v + 1];
        boolean[] visit = new boolean[v + 1];
        Arrays.fill(dist, MAX);
        dist[n] = 0;
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            list[a].add(new Vertex(b, c));
        }
        PriorityQueue<Vertex> q = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.w - o2.w;
            }
        }
        );
        q.add(new Vertex(n, 0));
        while (!q.isEmpty()) {
            Vertex nowV = q.poll();
            int now = nowV.v;
            if (visit[now])
                continue;
            visit[now] = true;
            for (Vertex nextV : list[now]) {
                int next = nextV.v;
                int weight = nextV.w;
                if (dist[next] > dist[now] + weight) {
                    dist[next] = dist[now] + weight;
                    q.add(new Vertex(next, dist[next]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (dist[i] == MAX)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
