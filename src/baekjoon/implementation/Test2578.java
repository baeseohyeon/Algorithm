package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2578 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Point[] points = new Point[26];
        int[][] arr = new int[5][5];
        for (int i = 0; i < 25; i++) {
            if (i % 5 == 0) {
                st = new StringTokenizer(br.readLine());
            }
            int num = parseInt(st.nextToken());
            arr[i / 5][i % 5] = num;
            points[num] = new Point(i / 5, i % 5);
        }

        int cnt = 0;
        for (int i = 0; i < 25; i++) {
            if (i % 5 == 0) {
                st = new StringTokenizer(br.readLine());
            }
            cnt++;
            int num = parseInt(st.nextToken());
            arr[points[num].x][points[num].y] = 0;
            if (isBingo(arr)) {
                System.out.println(cnt);
                return;
            }
        }
    }

    private static boolean isBingo(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean isClear = true;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) {
                    isClear = false;
                    break;
                }
            }
            cnt = isClear ? cnt + 1 : cnt;
            isClear = true;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != 0) {
                    isClear = false;
                    break;
                }
            }
            cnt = isClear ? cnt + 1 : cnt;
        }
        if (arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0 && arr[3][3] == 0 && arr[4][4] == 0) {
            cnt++;
        }

        if (arr[0][4] == 0 && arr[1][3] == 0 && arr[2][2] == 0 && arr[3][1] == 0 && arr[4][0] == 0) {
            cnt++;
        }
        return cnt >= 3;
    }
}