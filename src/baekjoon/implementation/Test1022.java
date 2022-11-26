package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1022 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r1 = parseInt(s[0]), c1 = parseInt(s[1]), r2 = parseInt(s[2]), c2 = parseInt(s[3]);
        int[][] map = new int[r2 - r1 + 1][c2 - c1 + 1];
        int x = 0, y = 0, d = 0, num = 0, moveCnt = 0, maxMoveCnt = 1;
        while (canMove(map, r1, c1, r2, c2)) {
            num++;
            moveCnt++;
            if (x >= r1 && y >= c1 && x <= r2 && y <= c2) {
                map[x - r1][y - c1] = num;
            }
            x = x + dx[d];
            y = y + dy[d];
            if (moveCnt == maxMoveCnt) {
                if (d % 2 == 1) {
                    maxMoveCnt++;
                }
                moveCnt = 0;
                d = (d + 1) % 4;
            }
        }

        int len = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                len = Math.max(len, Integer.toString(map[i][j]).length());
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%" + len + "d ", map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean canMove(int[][] map, int r1, int c1, int r2, int c2) {
        return map[0][0] == 0 || map[0][c2 - c1] == 0 || map[r2 - r1][0] == 0 || map[r2 - r1][c2 - c1] == 0;
    }
}
