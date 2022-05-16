package baekjoon.sort;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1826 { //https://dlee0129.tistory.com/211

    static class GasStation {

        int distance, fuel;

        GasStation(int distance, int fuel) {
            this.distance = distance;
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<GasStation> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new GasStation(parseInt(st.nextToken()), parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        int l = parseInt(st.nextToken());
        int p = parseInt(st.nextToken());
        int cnt = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (p < l) {
            while (!pq.isEmpty() && (pq.peek().distance <= p)) {
                q.add(pq.poll().fuel);
            }
            if (q.isEmpty()) {
                System.out.println(-1);
                return;
            }
            p += q.poll();
            cnt++;
        }
        System.out.println(cnt);
    }
}
