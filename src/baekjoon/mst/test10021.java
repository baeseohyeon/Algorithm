package baekjoon.mst;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test10021 {

    static int n, c;
    static int[] parent;
    static XY[] xy;
    static PriorityQueue<Line> pq;

    static class XY {

        int x, y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {

        int idx1, idx2, len;

        Line(int idx1, int idx2, int len) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        parent = new int[n + 1];
        pq = new PriorityQueue<>((o1, o2) -> o1.len - o2.len);
        xy = new XY[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            xy[i] = new XY(x, y);
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                int len = getLen(xy[i].x, xy[i].y, xy[j].x, xy[j].y);
                if (len >= c) {
                    pq.add(new Line(i, j, len));
                }
            }
        }
        int cnt = 0, ans = 0;
        while (!pq.isEmpty() && cnt < n - 1) {
            Line line = pq.poll();
            int leftNodeIdx = line.idx1;
            int rightNodeIdx = line.idx2;
            int leftParent = find(leftNodeIdx);
            int rightParent = find(rightNodeIdx);
            if (leftParent == rightParent) {
                continue;
            }
            parent[leftParent] = rightParent;
            ans += line.len;
            cnt++;
        }
        System.out.println(cnt == n - 1 ? ans : -1);
    }

    private static int find(int now) {
        if (now == parent[now]) {
            return now;
        }
        return parent[now] = find(parent[now]);
    }

    private static int getLen(int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

