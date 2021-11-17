package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test1374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = parseInt(s[0]);
            arr[i][1] = parseInt(s[1]);
            arr[i][2] = parseInt(s[2]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= arr[i][1]) {
                pq.poll();
            }
            pq.add(arr[i][2]);
            cnt = Math.max(cnt, pq.size());
        }
        System.out.println(cnt);
    }
}
