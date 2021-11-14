package baekjoon.dijkstra;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class test11779 {

    static class Node {

        int next, weight;

        Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    static int n, m;
    static List<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = parseInt(br.readLine());
        m = parseInt(br.readLine());
        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = parseInt(s[0]);
            int b = parseInt(s[1]);
            int c = parseInt(s[2]);
            nodes[a].add(new Node(b, c));
        }
        String[] s = br.readLine().split(" ");
        int start = parseInt(s[0]);
        int end = parseInt(s[1]);
        int[] dist = new int[n + 1];
        int[] arr = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dist, MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
        pq.add(start);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (visit[now]) {
                continue;
            }
            visit[now] = true;
            for (Node node : nodes[now]) {
                int weight = node.weight;
                int next = node.next;
                if (dist[next] >= dist[now] + weight) {
                    dist[next] = dist[now] + weight;
                    arr[next] = now;
                    pq.add(next);
                }
            }
        }
        Stack<Integer> st = new Stack<>();
        for (int i = end; i != start; i = arr[i]) {
            st.push(i);
        }
        st.push(start);
        bw.write(dist[end] + "\n" + st.size() + "\n");
        while (!st.isEmpty()) {
            bw.write(st.pop() + " ");
        }
        bw.flush();
    }
}
