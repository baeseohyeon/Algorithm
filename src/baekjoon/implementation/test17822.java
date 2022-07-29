package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17822 {

    static boolean isDeleted;
    static int n, m, t;
    static boolean[][] visit;
    static int[][] disk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        t = parseInt(st.nextToken());
        disk = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                disk[i][j] = parseInt(st.nextToken());
            }
        }
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());
            int k = parseInt(st.nextToken());
            if (k != m) { //360도 회전 아닐때
                spinDisk(x, d, k);
            }
            checkNearDisk();
            if (isDeleted) {
                deleteDiskNum();
            } else {
                double avg = getAvg();
                addDiskNum(avg);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (disk[i][j] > 0) {
                    ans += disk[i][j];
                }
            }
        }
        System.out.println(ans);
    }

    private static void addDiskNum(double avg) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (disk[i][j] == -1) {
                    continue;
                }
                if (disk[i][j] > avg) {
                    disk[i][j]--;
                } else if (disk[i][j] < avg) {
                    disk[i][j]++;
                }
            }
        }
    }

    private static double getAvg() {
        int cnt = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (disk[i][j] > 0) {
                    cnt++;
                    sum += disk[i][j];
                }
            }
        }
        return (double) sum / cnt;
    }

    private static void deleteDiskNum() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) {
                    disk[i][j] = -1;
                }
            }
        }
    }

    private static void checkNearDisk() {
        visit = new boolean[n][m];
        isDeleted = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = disk[i][j];
                if (num == -1) {
                    continue;
                }
                if (j == 0 && num == disk[i][m - 1]) {
                    visit[i][j] = true;
                    visit[i][m - 1] = true;
                    isDeleted = true;
                }
                if (i + 1 < n && num == disk[i + 1][j]) {
                    visit[i][j] = true;
                    visit[i + 1][j] = true;
                    isDeleted = true;
                }
                if (i - 1 >= 0 && num == disk[i - 1][j]) {
                    visit[i][j] = true;
                    visit[i - 1][j] = true;
                    isDeleted = true;
                }
                if (j - 1 >= 0 && num == disk[i][j - 1]) {
                    visit[i][j] = true;
                    visit[i][j - 1] = true;
                    isDeleted = true;
                }
                if (j + 1 < m && num == disk[i][j + 1]) {
                    visit[i][j] = true;
                    visit[i][j + 1] = true;
                    isDeleted = true;
                }
            }
        }
    }

    private static void spinDisk(int x, int d, int k) {
        for (int i = 0; i < n; i++) {
            if ((i + 1) % x == 0) {
                int[] arr = new int[m];
                if (d == 0) {
                    for (int j = 0; j < m; j++) {
                        arr[(j + k) % m] = disk[i][j];
                    }
                } else {
                    for (int j = 0; j < m; j++) {
                        arr[(m + (j - k % m)) % m] = disk[i][j];
                    }
                }
                for (int j = 0; j < m; j++) {
                    disk[i][j] = arr[j];
                }
            }
        }
    }
}
