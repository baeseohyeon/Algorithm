package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test19638 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int h = parseInt(st.nextToken());
        int t = parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 1; i <= n; i++) {
            int num = parseInt(br.readLine());
            if (num >= h) {
                pq.add(num);
            }
        }
        int cnt = t;
        while (!pq.isEmpty() && cnt-- > 0) {
            int num = Math.max(pq.poll() / 2, 1);
            if (num >= h) {
                pq.add(num);
            }
        }
        System.out.println(pq.isEmpty() ? "YES\n" + (t - cnt) : "NO\n" + pq.poll());
    }
}
