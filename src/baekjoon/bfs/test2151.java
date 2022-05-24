package baekjoon.bfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class test2151 { //https://soboruya.tistory.com/44

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

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][][] visit = new boolean[n][n][4];
        int initX = 0, initY = 0;
        PriorityQueue<XY> pq = new PriorityQueue<>((xy1, xy2) -> xy1.cnt - xy2.cnt);
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '#' && pq.isEmpty()) {
                    initX = i;
                    initY = j;
                    for (int k = 0; k < 4; k++) {
                        pq.add(new XY(i, j, k, 0));
                    }
                }
            }
        }
        while (!pq.isEmpty()) {
            XY xy = pq.poll();
            int x = xy.x;
            int y = xy.y;
            int d = xy.d;
            int cnt = xy.cnt;
            if(visit[x][y][d]){
                continue;
            }
            visit[x][y][d]=true;
            if (map[x][y] == '#' && !(x == initX && y == initY)) {
                System.out.println(cnt);
                return;
            }
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == '*' || visit[nx][ny][d]) {
                continue;
            }
            if (map[nx][ny] == '!') {
                int nextD = d + 1 >= 4 ? 0 : d + 1;
                pq.add(new XY(nx, ny, nextD, cnt + 1));
                nextD = d - 1 < 0 ? 3 : d - 1;
                pq.add(new XY(nx, ny, nextD, cnt + 1));
            }
            pq.add(new XY(nx, ny, d, cnt));
        }
    }
}
