package baekjoon.topologicalsorting;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test9470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int k = parseInt(s[0]);
            int m = parseInt(s[1]);
            int p = parseInt(s[2]);
            int[] level = new int[m + 1];
            int[] check = new int[m + 1];
            int[] count = new int[m + 1];
            List<Integer>[] list = new ArrayList[m + 1];
            for (int i = 0; i <= m; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < p; i++) {
                s = br.readLine().split(" ");
                int a = parseInt(s[0]);
                int b = parseInt(s[1]);
                check[b]++;
                list[a].add(b);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= m; i++) {
                if (check[i] == 0) {
                    level[i] = 1;
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int next : list[now]) {
                    check[next]--;
                    if (level[next] < level[now]) {
                        level[next] = level[now];
                        count[next] = 0;
                    }
                    count[next]++;
                    if (check[next] == 0) {
                        q.add(next);
                        if (count[next] > 1) {
                            level[next]++;
                        }
                    }
                }
            }
            System.out.println(k + " " + level[m]);
        }
    }
}
