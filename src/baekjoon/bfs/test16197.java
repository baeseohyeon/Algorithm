package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16197 {

    static class Pair {

        int x, y, cnt;

        Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new char[n][m];
        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'o') {
                    q1.add(new Pair(i, j, 0));
                }
            }
        }
        q2.add(q1.poll());
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Pair p1 = q1.poll();
            Pair p2 = q2.poll();
            int x1 = p1.x;
            int y1 = p1.y;
            int x2 = p2.x;
            int y2 = p2.y;
            int cnt = p1.cnt;
            if (cnt > 10) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];
                if (isOut(nx1, ny1) && isOut(nx2, ny2)) {
                    continue;
                }
                if ((isOut(nx1, ny1) && !isOut(nx2, ny2)) ||
                    (!isOut(nx1, ny1) && isOut(nx2, ny2))) {
                    System.out.println(cnt + 1 > 10 ? -1 : cnt + 1);
                    return;
                }
                if (map[nx1][ny1] == '#') {
                    nx1 = x1;
                    ny1 = y1;
                }
                if (map[nx2][ny2] == '#') {
                    nx2 = x2;
                    ny2 = y2;
                }
                if ((nx1 == x1 && nx2 == x2 && ny1 == y1 && ny2 == y2)) {
                    continue;
                }
                q1.add(new Pair(nx1, ny1, cnt + 1));
                q2.add(new Pair(nx2, ny2, cnt + 1));
            }
        }
        System.out.println(-1);
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

}
