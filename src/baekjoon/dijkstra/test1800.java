package baekjoon.dijkstra;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test1800 { //https://redbinalgorithm.tistory.com/627

    static int n, p, k, ans = -1;
    static int[] dist;
    static List<Node>[] nodes;

    static class Node {

        int next, distance;

        Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        p = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        dist = new int[n + 1];
        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }
        binarySearch();
        System.out.println(ans);
    }

    private static void binarySearch() {
        int left = 0, right = 1000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private static boolean dijkstra(int target) {
        Arrays.fill(dist, MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
        pq.add(1);
        while (!pq.isEmpty()) {
            int now = pq.poll();
            for (Node node : nodes[now]) {
                int next = node.next;
                int distance = node.distance <= target ? 0 : 1;
                if (dist[next] > dist[now] + distance) {
                    dist[next] = dist[now] + distance;
                    pq.add(next);
                }
            }
        }
        return dist[n] <= k;
    }
}
