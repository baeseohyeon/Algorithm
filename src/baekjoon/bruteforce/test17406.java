package baekjoon.bruteforce;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17406 {

    static int n, m, k, ans = MAX_VALUE;
    static int[][] arr, orders;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        orders = new int[k][3];
        visit = new boolean[k];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            orders[i][0] = parseInt(st.nextToken());
            orders[i][1] = parseInt(st.nextToken());
            orders[i][2] = parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            dfs(i, 1, arr);
        }
        System.out.println(ans);
    }

    private static void dfs(int now, int cnt, int[][] prevArr) {
        visit[now] = true;
        int[][] nowArr = copyArr(prevArr);
        rotate(now, nowArr);
        if (cnt == k) {
            ans = Math.min(ans, getValueOfA(nowArr));
        } else {
            for (int i = 0; i < k; i++) {
                if (!visit[i]) {
                    dfs(i, cnt + 1, nowArr);
                }
            }
        }
        visit[now] = false;
    }

    private static int getValueOfA(int[][] nowArr) {
        int value = MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += nowArr[i][j];
            }
            value = Math.min(value, sum);
        }
        return value;
    }

    private static void rotate(int order, int[][] nowArr) {
        int r = orders[order][0];
        int c = orders[order][1];
        int s = orders[order][2];
        int startR = r - s;
        int startC = c - s;
        int endR = r + s;
        int endC = c + s;
        while (startR < r) { //시계방향 회전
            int tmp = nowArr[startR][startC];
            for (int i = startR; i < endR; i++) {
                nowArr[i][startC] = nowArr[i + 1][startC];
            }
            for (int i = startC; i < endC; i++) {
                nowArr[endR][i] = nowArr[endR][i + 1];
            }
            for (int i = endR; i > startR; i--) {
                nowArr[i][endC] = nowArr[i - 1][endC];
            }
            for (int i = endC; i > startC; i--) {
                nowArr[startR][i] = nowArr[startR][i - 1];
            }
            nowArr[startR][startC + 1] = tmp;
            startR++;
            startC++;
            endR--;
            endC--;
        }
    }

    private static int[][] copyArr(int[][] nowArr) {
        int[][] tmp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                tmp[i][j] = nowArr[i][j];
            }
        }
        return tmp;
    }
}
