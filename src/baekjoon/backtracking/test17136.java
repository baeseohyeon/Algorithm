package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17136 {

    public static boolean checkSquare(int x, int y, int num) {
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                if (i >= 10 || j >= 10 || arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void checkVisit(int x, int y, int num, int k) {
        for (int i = x; i < x + num; i++) {
            for (int j = y; j < y + num; j++) {
                arr[i][j] = k;
            }
        }
    }

    public static void solve(int x, int y, int cnt) {
        if (x >= 9 && y > 9) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (cnt > ans)
            return;
        if (y > 9) {
            solve(x + 1, 0, cnt);
            return;
        }
        if (arr[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (checkSquare(x, y, i) && paper[i] > 0) {
                    paper[i]--;
                    checkVisit(x, y, i, 0);
                    solve(x, y + 1, cnt + 1);
                    checkVisit(x, y, i, 1);
                    paper[i]++;
                }
            }
        } else {
            solve(x, y + 1, cnt);
        }
    }

    static int ans = 100;
    static int paper[] = new int[6];
    static int arr[][] = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        paper[1] = paper[2] = paper[3] = paper[4] = paper[5] = 5;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, 0);
        System.out.println(ans == 100 ? -1 : ans);
    }
}
