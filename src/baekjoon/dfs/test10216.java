package baekjoon.dfs;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.*;

public class test10216 {

    static int n;
    static int[] parent;
    static Pair[] pairs;

    static class Pair {
        int x, y, d;

        Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            n = parseInt(br.readLine());
            pairs = new Pair[n + 1];
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                String[] s = br.readLine().split(" ");
                int x = parseInt(s[0]);
                int y = parseInt(s[1]);
                int d = parseInt(s[2]);
                parent[i] = i;
                pairs[i] = new Pair(x, y, d);
            }
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int len = (int) (Math.pow(pairs[i].x - pairs[j].x, 2) + Math.pow(pairs[i].y - pairs[j].y, 2));
                    int len2 = (int) (Math.pow(pairs[i].d + pairs[j].d, 2));
                    if(len<=len2){
                        union(i,j);
                    }
                }
            }
            Set<Integer> ans = new HashSet<>();
            for(int i=1; i<=n; i++){
                ans.add(find(i));
            }
            bw.write(ans.size()+"\n");
        }
        bw.flush();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int now) {
        if (now == parent[now])
            return now;
        return find(parent[now]);
    }
}
