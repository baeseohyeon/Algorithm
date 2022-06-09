package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class test6087 {

    static int w, h, sx, sy;
    static boolean[][][] visit;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class XY {

        int x, y, d, cnt;

        XY(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        w = parseInt(s[0]);
        h = parseInt(s[1]);
        visit = new boolean[h][w][4];
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'C') {
                    sx = i;
                    sy = j;
                }
            }
        }
        PriorityQueue<XY> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        for (int i = 0; i < 4; i++) {
            pq.add(new XY(sx, sy, i, 0));
        }
        while (!pq.isEmpty()) {
            XY xy = pq.poll();
            int x = xy.x;
            int y = xy.y;
            int d = xy.d;
            int cnt = xy.cnt;
            if (visit[x][y][d]) {
                continue;
            }
            visit[x][y][d] = true;
            if (map[x][y] == 'C' && !(x == sx && y == sy)) {
                System.out.println(cnt);
                return;
            }

            int nextD = (d + 1) % 4;
            int nx = x + dx[nextD];
            int ny = y + dy[nextD];
            if (isPossible(nx, ny)) {
                pq.add(new XY(nx, ny, nextD, cnt + 1));
            }

            nextD = d - 1 < 0 ? 3 : d - 1;
            nx = x + dx[nextD];
            ny = y + dy[nextD];
            if (isPossible(nx, ny)) {
                pq.add(new XY(nx, ny, nextD, cnt + 1));
            }

            nx = x + dx[d];
            ny = y + dy[d];
            if (isPossible(nx, ny)) {
                pq.add(new XY(nx, ny, d, cnt));
            }

        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '*') {
            return false;
        }
        return true;
    }
}
