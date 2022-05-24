package baekjoon.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test16954 {

    static int n = 8;
    static char[][] map = new char[n][n];
    static int[] dx = {0, -1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, 0, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = n - 1; i >= 0; i--) {
            map[i] = br.readLine().toCharArray();
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point now = q.poll();
                int x = now.x;
                int y = now.y;
                if (map[x][y] == '#') {
                    continue;
                }
                for (int i = 0; i < 9; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == '#') {
                        continue;
                    }
                    if (nx == n - 1 && ny == n - 1) {
                        System.out.println(1);
                        return;
                    }
                    q.add(new Point(nx, ny));
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = '.';
                }
            }
        }
        System.out.println(0);
    }
}

