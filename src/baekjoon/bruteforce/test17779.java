package baekjoon.bruteforce;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test17779 { //https://lotuslee.tistory.com/22

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        System.out.println(solution());
    }

    public static int solution() {
        int ans = MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int d1 = 1; j - d1 >= 1; d1++) {
                    for (int d2 = 1; i + d1 + d2 <= n && j + d2 <= n; d2++) {
                        int[][] area = new int[n + 1][n + 1];
                        setArea(i, j, d1, d2, area);
                        int[] population = getPopulation(area);
                        int difference = getPopulationDifference(population);
                        ans = Math.min(ans, difference);
                    }
                }
            }
        }
        return ans;
    }

    private static int getPopulationDifference(int[] population) {
        Arrays.sort(population);
        return population[5] - population[1];
    }

    private static int[] getPopulation(int[][] area) {
        int[] population = new int[6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                population[area[i][j]] += map[i][j];
            }
        }
        return population;
    }

    private static void setArea(int x, int y, int d1, int d2, int[][] area) {
        int sy = y;
        int ey = y;
        int cnt1 = d1;
        int cnt2 = d2;
        for (int i = x; i <= x + d1 + d2; i++) {
            for (int j = sy; j <= ey; j++) {
                area[i][j] = 5;
            }
            if (cnt1 > 0) {
                sy--;
                cnt1--;
            } else {
                sy++;
            }
            if (cnt2 > 0) {
                ey++;
                cnt2--;
            } else {
                ey--;
            }
        }
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= x + d2; i++) {
            for (int j = y + 1; j <= n; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 2;
                }
            }
        }
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 3;
                }
            }
        }
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j = y - d1 + d2; j <= n; j++) {
                if (area[i][j] == 0) {
                    area[i][j] = 4;
                }
            }
        }
    }
}
