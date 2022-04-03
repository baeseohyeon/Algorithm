package baekjoon.bfs;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test2933 {

    static int r, c, n, h, turn;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static List<XY> cluster;
    static char[][] map;

    static class XY {

        int x, y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        map = new char[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            String str = br.readLine();
            for (int j = 1; j <= c; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        n = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            h = parseInt(st.nextToken());
            throwStick();
            turn++;
        }
        print();
    }

    private static void throwStick() {
        if (isMineralExists() && isMineralInTheAir()) {
            moveCluster();
        }
    }

    private static boolean isMineralExists() {
        if (turn % 2 == 0) {
            for (int i = 1; i <= c; i++) {
                if (map[r - h + 1][i] == 'x') {
                    map[r - h + 1][i] = '.';
                    return true;
                }
            }
        } else {
            for (int i = c; i >= 1; i--) {
                if (map[r - h + 1][i] == 'x') {
                    map[r - h + 1][i] = '.';
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isMineralInTheAir() {
        visit = new boolean[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (!visit[i][j] && map[i][j] == 'x') { //미네랄 발견
                    cluster = new ArrayList<>();
                    bfs(i, j);
                    sort(cluster, (o1, o2) -> o2.x - o1.x); //미네랄 높이 내림차순
                    if (cluster.get(0).x < r) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void bfs(int x, int y) {
        XY now = new XY(x, y);
        Queue<XY> q = new LinkedList<>();
        q.add(now);
        cluster.add(now);
        visit[x][y] = true;
        while (!q.isEmpty()) {
            now = q.poll();
            x = now.x;
            y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isRoad(nx, ny)) {
                    visit[nx][ny] = true;
                    XY next = new XY(nx, ny);
                    q.add(next);
                    cluster.add(next);
                }
            }
        }
    }

    private static boolean isRoad(int x, int y) {
        if (x < 1 || y < 1 || x > r || y > c || visit[x][y] || map[x][y] != 'x') {
            return false;
        }
        return true;
    }

    private static void moveCluster() {
        int height = getMinHeight();
        for (XY xy : cluster) {
            int x = xy.x;
            int y = xy.y;
            map[x + height][y] = map[x][y];
            map[x][y] = '.';
        }
    }

    private static int getMinHeight() {
        boolean[] checkCluster = new boolean[c + 1];
        int height = MAX_VALUE;
        for (XY xy : cluster) {
            int x = xy.x;
            int y = xy.y;
            int cnt = 0;
            if (checkCluster[y]) {
                continue;
            }
            checkCluster[y] = true;
            for (int i = x + 1; i <= r; i++) {
                if (map[i][y] == '.') {
                    cnt++;
                } else {
                    break;
                }
            }
            height = Math.min(height, cnt);
        }
        return height;
    }

    public static void print() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
