package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test13335 {

    static class Truck {

        int initTime, weight;

        Truck(int initTime, int weight) {
            this.initTime = initTime;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int w = parseInt(st.nextToken());
        int l = parseInt(st.nextToken());
        Queue<Truck> bridge = new LinkedList<>();
        Deque<Truck> wait = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            wait.addFirst(new Truck(-1, parseInt(st.nextToken())));
        }
        int weightSum = 0, time = 0;
        while (true) {
            int size = bridge.size();
            while (size-- > 0) {
                Truck truck = bridge.poll();
                if (time - truck.initTime == w) {
                    weightSum -= truck.weight;
                } else {
                    bridge.add(truck);
                }
            }
            if (!wait.isEmpty()) {
                Truck waitTruck = wait.pollLast();
                if (weightSum + waitTruck.weight <= l) {
                    bridge.add(new Truck(time, waitTruck.weight));
                    weightSum += waitTruck.weight;
                } else {
                    wait.addLast(waitTruck);
                }
            }
            time++;
            if (wait.isEmpty() && bridge.isEmpty()) {
                break;
            }
        }
        System.out.println(time);
    }
}
