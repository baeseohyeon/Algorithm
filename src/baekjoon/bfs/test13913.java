package baekjoon.bfs;

import java.util.*;

public class test13913 {
    static int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[MAX + 1];
        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dp[n] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k) {
                Stack<Integer> s = new Stack<>();
                System.out.println(dp[now]);
                int idx = k;
                while (idx != n) {
                    s.push(idx);
                    idx = arr[idx];
                }
                s.push(idx);
                while (!s.isEmpty()) {
                    System.out.print(s.pop() + " ");
                }
                break;
            }
            int[] move = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int next = move[i];
                if (next < 0 || next > MAX || dp[next] != -1)
                    continue;
                dp[next] = dp[now] + 1;
                arr[next] = now;
                q.add(next);
            }
        }
    }
}
