package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10775 {

    static int[] parent;

    public static int find(int now) {
        if (parent[now] == now) {
            return now;
        }
        return parent[now] = find(parent[now]);
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = parseInt(br.readLine());
        int p = parseInt(br.readLine());
        int[] airPlanes = new int[p + 1];
        parent = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 1; i <= p; i++) {
            airPlanes[i] = parseInt(br.readLine());
            int nowParent = find(airPlanes[i]);
            if (nowParent == 0) {
                break;
            }
            union(nowParent, nowParent - 1);
            ans++;
        }
        System.out.println(ans);
    }
}
