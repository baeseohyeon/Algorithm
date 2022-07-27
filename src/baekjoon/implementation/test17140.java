package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test17140 {

    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken()) - 1;
        m = parseInt(st.nextToken()) - 1;
        k = parseInt(st.nextToken());
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = parseInt(st.nextToken());
            }
        }
        System.out.println(solution(3, 3, arr, 0));
    }

    public static int solution(int r, int c, int[][] arr, int cnt) {
        if (n < arr.length && m < arr[0].length && arr[n][m] == k) {
            return cnt;
        }
        int max = 0;
        int[][] nextArr;
        List<List<Integer>> nextList = new ArrayList<>();
        if (r >= c) {
            for (int i = 0; i < r; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < c; j++) {
                    setMap(map, arr[i][j]);
                }
                List<Integer> line = getLine(map);
                max = Math.max(max, line.size());
                nextList.add(line);
            }
            nextArr = new int[r][max];
            for (int i = 0; i < nextList.size(); i++) {
                List<Integer> tmp = nextList.get(i);
                for (int j = 0; j < tmp.size(); j++) {
                    nextArr[i][j] = tmp.get(j);
                }
            }
        } else {
            for (int i = 0; i < c; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < r; j++) {
                    setMap(map, arr[j][i]);
                }
                List<Integer> line = getLine(map);
                max = Math.max(max, line.size());
                nextList.add(line);
            }
            nextArr = new int[max][c];
            for (int i = 0; i < nextList.size(); i++) {
                List<Integer> tmp = nextList.get(i);
                for (int j = 0; j < tmp.size(); j++) {
                    nextArr[j][i] = tmp.get(j);
                }
            }
        }
        if (cnt < 100) {
            return solution(nextArr.length, nextArr[0].length, nextArr, cnt + 1);
        }
        return -1;
    }

    private static List<Integer> getLine(Map<Integer, Integer> map) {
        List<Integer> line = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return o1 - o2;
            }
            return map.get(o1) - map.get(o2);
        });
        pq.addAll(map.keySet());
        while (!pq.isEmpty()) {
            int num = pq.poll();
            line.add(num);
            line.add(map.get(num));
        }
        return line;
    }

    private static void setMap(Map<Integer, Integer> map, int num) {
        if (num == 0) {
            return;
        }
        if (!map.containsKey(num)) {
            map.put(num, 1);
        } else {
            map.put(num, map.get(num) + 1);
        }
    }
}
