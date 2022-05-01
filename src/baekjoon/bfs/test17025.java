package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test17025 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, maxArea, maxCircumference;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        map = new char[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(maxArea + " " + maxCircumference);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visit[x][y] = true;
        int area = 1, circumference = 0;
        q.add(new Point(x,y));
        while (!q.isEmpty()) {
            Point now = q.poll();
            x = now.x;
            y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == '.') {
                    circumference++;
                    continue;
                }
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    area++;
                }
            }
        }
        if (area >= maxArea) {
            if (area == maxArea) {
                maxCircumference = Math.min(maxCircumference, circumference);
            } else {
                maxArea = area;
                maxCircumference = circumference;
            }
        }
    }
}
