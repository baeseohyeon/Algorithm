package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test17780 {

    static boolean isEnd;
    static int n, k;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static XY[] xyArr;
    static Queue<XY> q;
    static List<XY>[][] list;

    static class XY {

        int x, y, d, idx;
        boolean isRoot;

        XY(int x, int y, int d, int idx, boolean isRoot) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.idx = idx;
            this.isRoot = isRoot;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        q = new LinkedList<>();
        xyArr = new XY[k + 1];
        list = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = parseInt(st.nextToken());
                list[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            XY xy = new XY(x, y, d, i, true);
            list[x][y].add(xy);
            xyArr[i] = xy;
        }
        int turn = 0;
        while (turn++ < 1000) { // 1 오른    2: 왼    3: 위   4: 아래
            for (int i = 1; i <= k; i++) {
                XY now = xyArr[i];
                boolean isRoot = now.isRoot;
                if (!isRoot) {
                    continue;
                }
                int x = now.x;
                int y = now.y;
                int d = now.d;
                int idx = now.idx;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (isOut(nx, ny) || map[nx][ny] == 2) { // 다음칸이 밖으로 나가거나 파란색
                    d = d % 2 == 0 ? d - 1 : d + 1;
                    nx = x + dx[d];
                    ny = y + dy[d];
                    xyArr[idx].d = d; //방향 변경
                    if (isOut(nx, ny) || map[nx][ny] == 2) { //또 밖으로 나가거나 파란색일때
                        continue;
                    }
                }
                move(x, y, nx, ny, map[nx][ny] == 1);
            }
            if (isEnd) {
                break;
            }
        }
        System.out.println(turn >= 1000 ? -1 : turn);
    }

    private static void move(int x, int y, int nx, int ny, boolean isRed) {
        if (isRed) {
            addListReverse(x, y, nx, ny);
        } else {
            addList(x, y, nx, ny);
        }
        XY rootXY = list[nx][ny].get(0);
        xyArr[rootXY.idx].isRoot = true;
        if (list[nx][ny].size() >= 4) {
            isEnd = true;
        }
    }

    private static void addListReverse(int x, int y, int nx, int ny) {
        for (int i = list[x][y].size() - 1; i >= 0; i--) {
            XY xy = list[x][y].get(i);
            xyArr[xy.idx].x = nx;
            xyArr[xy.idx].y = ny;
            xyArr[xy.idx].isRoot = false;
            list[nx][ny].add(xy);
        }
        list[x][y].clear();
    }

    private static void addList(int x, int y, int nx, int ny) {
        for (XY xy : list[x][y]) {
            xyArr[xy.idx].x = nx;
            xyArr[xy.idx].y = ny;
            xyArr[xy.idx].isRoot = false;
            list[nx][ny].add(xy);
        }
        list[x][y].clear();
    }

    private static boolean isOut(int x, int y) {
        if (x < 1 || y < 1 || x > n || y > n) {
            return true;
        }
        return false;
    }
}
