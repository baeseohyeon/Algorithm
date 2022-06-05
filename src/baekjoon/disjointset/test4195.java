package baekjoon.disjointset;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class test4195 {

    static Map<String, String> parent;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            parent = new HashMap<>();
            map = new HashMap<>();
            int f = parseInt(br.readLine());
            for (int i = 0; i < f; i++) {
                String[] s = br.readLine().split(" ");
                if (!parent.containsKey(s[0])) {
                    parent.put(s[0], s[0]);
                    map.put(s[0], 1);
                }
                if (!parent.containsKey(s[1])) {
                    parent.put(s[1], s[1]);
                    map.put(s[1], 1);
                }
                String parent0 = find(s[0]);
                String parent1 = find(s[1]);
                if (!parent0.equals(parent1)) {
                    merge(parent0, parent1);
                }
                bw.write(map.get(parent0) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static String find(String now) {
        if (now.equals(parent.get(now))) {
            return now;
        }
        return parent.get(parent.put(now, find(parent.get(now))));
    }

    public static void merge(String s1, String s2) {
        parent.put(s2, s1);
        map.put(s1, map.get(s1) + map.get(s2));
    }
}
