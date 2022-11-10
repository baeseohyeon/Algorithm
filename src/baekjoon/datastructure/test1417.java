package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class test1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int dasom = parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            pq.add(parseInt(br.readLine()));
        }
        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom + cnt) {
            int num = pq.poll();
            pq.add(num - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
