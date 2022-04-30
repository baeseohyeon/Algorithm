package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test15235 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
            q.add(i);
        }
        int cnt = 0;
        int[] ans = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            cnt++;
            arr[now]--;
            if (arr[now] == 0) {
                ans[now] = cnt;
            } else {
                q.add(now);
            }
        }
        for(int i=1; i<=n; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
