package baekjoon.simulation;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test11559 {

    static int n = 12, m = 6;
    static boolean isExplode = false;
    static boolean[][] visit;
    static char[][] map;
    static List<Point> blocks;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int cnt = 0;
        while (true) {
            isExplode = false;

            while (isChained()) {
                isExplode = true;
                bombBlock();
            }

            findMoveBlock();

            if (!isExplode) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void findMoveBlock() {
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            while (flag) {
                int top = -1, bottom = -1;

                for (int j = 0; j < n; j++) {
                    if (map[j][i] == '.') {
                        continue;
                    }
                    top = j;

                    for (int k = top + 1; k < n; k++) {
                        if (map[k][i] == '.') {
                            bottom = k - 1;
                            break;
                        }
                    }

                    if (bottom == -1) {
                        flag = false;
                        break;
                    }

                    int len = getLen(i, bottom);
                    moveBlock(i, top, bottom, len);
                    break;
                }

                if (top == -1) {
                    flag = false;
                }
            }
        }
    }

    private static int getLen(int col, int bottom) {
        int len = 0;
        for (int k = bottom + 1; k < n; k++) {
            if (map[k][col] != '.') {
                break;
            }
            len++;
        }
        return len;
    }

    private static void moveBlock(int col, int top, int bottom, int len) {
        for (int k = bottom; k >= top; k--) {
            map[k + len][col] = map[k][col];
            map[k][col] = '.';
        }
    }

    private static void bombBlock() {
        for (Point block : blocks) {
            map[block.x][block.y] = '.';
        }
    }

    private static boolean isChained() {
        visit = new boolean[n][m];
        blocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '.' && !visit[i][j]) {
                    dfs(i, j);
                    if (blocks.size() >= 4) {
                        return true;
                    }
                    blocks.clear();
                }
            }
        }
        return false;
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        blocks.add(new Point(x, y));
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny]) {
                continue;
            }
            if (map[x][y] == map[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
