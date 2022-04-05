package baekjoon.greedy;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test1700 {

    static int n, k;
    static int[] products;
    static List<Integer> multiTap;
    static List<Integer>[] idxList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        products = new int[101];
        multiTap = new ArrayList<>();
        idxList = new ArrayList[101];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            idxList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= k; i++) {
            int num = parseInt(st.nextToken());
            products[i] = num;
            idxList[num].add(i);
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            int product = products[i];
            if (multiTap.size() < n) { //멀티탭이 비어있을때
                addProduct(product);
                continue;
            }
            //멀티탭이 꽉차 있을때
            if (multiTap.contains(product)) { //이미 사용중인 제품일때
                idxList[product].remove(0);
                continue;
            }
            int target = findRemoveProduct(i);
            multiTap.remove((Integer) target);
            addProduct(product);
            ans++;
        }
        System.out.println(ans);
    }

    private static int findRemoveProduct(int now) {
        int product = 0;
        int len = 0;
        for (int i : multiTap) {
            if (idxList[i].isEmpty()) { //더이상 사용되지 않는 제품일때
                return i;
            }
            int idx = idxList[i].get(0);
            if (idx - now > len) {
                product = i;
                len = idx - now;
            }
        }
        return product;
    }

    private static void addProduct(int product) {
        if (!multiTap.contains(product)) {
            multiTap.add(product);
        }
        idxList[product].remove(0);
    }
}
