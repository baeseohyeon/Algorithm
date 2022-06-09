package baekjoon.bfs;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16948 {

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], MAX_VALUE);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = parseInt(st.nextToken());
        int c1 = parseInt(st.nextToken());
        int r2 = parseInt(st.nextToken());
        int c2 = parseInt(st.nextToken());
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r1, c1));
        map[r1][c1] = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.x == r2 && now.y == c2) {
                System.out.println(map[now.x][now.y]);
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx > n || ny > n) {
                    continue;
                }
                if (map[nx][ny] > map[now.x][now.y] + 1) {
                    map[nx][ny] = map[now.x][now.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
        System.out.println(-1);
    }
}
