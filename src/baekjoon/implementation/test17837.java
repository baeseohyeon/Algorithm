package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test17837 {

    static boolean isEnd;
    static int n, k, turn;
    static int[][] map;
    static Knight[] knights;
    static List<Integer>[][] knightsMap;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    static class Knight {

        int x, y, d, idx = 0;

        Knight(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        knights = new Knight[k + 1];
        knightsMap = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = parseInt(st.nextToken());
                knightsMap[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            Knight knight = new Knight(x, y, d);
            knights[i] = knight;
            knightsMap[x][y].add(i);
        }
        while (turn < 1000) {
            for (int i = 1; i <= k; i++) {
                Knight now = knights[i];
                move(now);
            }
            turn++;
            if (isEnd) {
                System.out.println(turn);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void move(Knight knight) {
        int x = knight.x;
        int y = knight.y;
        int d = knight.d;
        int idx = knight.idx;
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (isBlue(nx, ny)) { //파란색
            knight.d = d % 2 == 0 ? d - 1 : d + 1;
            nx = x + dx[knight.d];
            ny = y + dy[knight.d];
            if (isBlue(nx, ny)) {
                return;
            }
        }
        if (map[nx][ny] == 1) {
            moveRed(idx, x, y, nx, ny);
        } else {
            moveWhite(idx, x, y, nx, ny);
        }
        for (int i = knightsMap[x][y].size() - 1; i >= idx; i--) {
            knightsMap[x][y].remove(i);
        }
        if (knightsMap[nx][ny].size() >= 4) {
            isEnd = true;
        }
    }

    private static void moveRed(int idx, int x, int y, int nx, int ny) {
        for (int i = knightsMap[x][y].size() - 1; i >= idx; i--) {
            int now = knightsMap[x][y].get(i);
            knights[now].x = nx;
            knights[now].y = ny;
            knightsMap[nx][ny].add(now);
            knights[now].idx = knightsMap[nx][ny].size() - 1;
        }
    }

    private static void moveWhite(int idx, int x, int y, int nx, int ny) {
        for (int i = idx; i < knightsMap[x][y].size(); i++) {
            int now = knightsMap[x][y].get(i);
            knights[now].x = nx;
            knights[now].y = ny;
            knightsMap[nx][ny].add(now);
            knights[now].idx = knightsMap[nx][ny].size() - 1;
        }
    }

    private static boolean isBlue(int x, int y) {
        return x <= 0 || y <= 0 || x > n || y > n || map[x][y] == 2;
    }
}
