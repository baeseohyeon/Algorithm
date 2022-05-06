package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test2784 {

    static int n;
    static boolean flag;
    static List<String> words;
    static boolean[] visit;
    static String[] map;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            words.add(br.readLine());
        }
        n = 3;
        map = new String[6];
        Collections.sort(words);
        for (int i = 0; i < 6; i++) {
            visit = new boolean[6];
            map[0] = words.get(i);
            visit[i] = true;
            dfs(0);
        }
        if (!flag) {
            System.out.println(0);
        }
    }

    private static void dfs(int idx) {
        if (flag) {
            return;
        }
        if (idx == n - 1) {
            if (isPuzzle()) {
                flag = true;
                for (int i = 0; i < 3; i++) {
                    System.out.println(map[i]);
                }
            }
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (!visit[i]) {
                visit[i] = true;
                map[idx + 1] = words.get(i);
                dfs(idx + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean isPuzzle() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(map[i]);
        }
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                tmp += map[j].charAt(i);
            }
            list.add(tmp);
        }
        boolean[] check = new boolean[6];
        for (String s : list) {
            for (int i = 0; i < 6; i++) {
                if (check[i]) {
                    continue;
                }
                if (s.equals(words.get(i))) {
                    check[i] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }
}
