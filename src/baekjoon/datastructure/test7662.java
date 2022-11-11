package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class test7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> asc = new PriorityQueue<>(); //최소힙
            PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
            int k = parseInt(br.readLine());
            while (k-- > 0) {
                String[] s = br.readLine().split(" ");
                if (s[0].equals("I")) {
                    int num = parseInt(s[1]);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    asc.add(num);
                    desc.add(num);
                    continue;
                }
                if (s[1].equals("1")) { //최댓값 삭제
                    while (!desc.isEmpty() && map.get(desc.peek()) == 0) {
                        desc.poll();
                    }
                    if (!desc.isEmpty()) {
                        int poll = desc.poll();
                        map.put(poll, map.get(poll) - 1);
                    }
                } else { //최솟값 삭제
                    while (!asc.isEmpty() && map.get(asc.peek()) == 0) {
                        asc.poll();
                    }
                    if (!asc.isEmpty()) {
                        int poll = asc.poll();
                        map.put(poll, map.get(poll) - 1);
                    }
                }
            }
            while (!desc.isEmpty() && map.get(desc.peek()) == 0) {
                desc.poll();
            }
            while (!asc.isEmpty() && map.get(asc.peek()) == 0) {
                asc.poll();
            }
            if (desc.isEmpty() || asc.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            }
            sb.append(desc.peek()).append(" ").append(asc.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
