package baekjoon.bellmanford;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test11657 {

    static boolean flag;
    static int MAX = 1000000000;

    static class Line {

        int v1, v2, len;

        Line(int v1, int v2, int len) {
            this.v1 = v1;
            this.v2 = v2;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        Line[] lines = new Line[m + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = parseInt(st.nextToken());
            int v2 = parseInt(st.nextToken());
            int len = parseInt(st.nextToken());
            lines[i] = new Line(v1, v2, len);
        }
        long[] dist = new long[n + 1];
        bellmanFord(n, dist, lines);
        if (flag) {
            System.out.println(-1);
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (dist[i] == MAX) {
                bw.write(-1 + "\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
    }

    private static void bellmanFord(int n, long[] dist, Line[] lines) {
        Arrays.fill(dist, MAX);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= lines.length - 1; j++) {
                Line line = lines[j];
                if (line.v1 == MAX) {
                    continue;
                }
                if (dist[line.v2] > dist[line.v1] + line.len) {
                    if (i == n) {
                        flag = true;
                    }
                    dist[line.v2] = dist[line.v1] + line.len;
                }
            }
        }
    }
}
