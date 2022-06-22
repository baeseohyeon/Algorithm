package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class test14725 {

    static int n;
    static StringBuffer sb;

    static class Tree {

        String data;
        List<Tree> children = new ArrayList<>();

        Tree(String data) {
            this.data = data;
        }

        Tree findChild(Tree tree) {
            for (Tree child : children) {
                if (child.equals(tree)) {
                    return child;
                }
            }
            return null;
        }

        boolean isChild(Tree tree) {
            return children.contains(tree);
        }

        void addChild(Tree tree) {
            children.add(tree);
        }

        void sortChildren() {
            Collections.sort(children, (o1, o2) -> o1.data.compareTo(o2.data));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Tree tree = (Tree) o;
            return data.equals(tree.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        sb = new StringBuffer();
        Tree root = new Tree("root");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = parseInt(st.nextToken());
            Tree now = root;
            for (int j = 0; j < k; j++) {
                Tree next = new Tree(st.nextToken());
                if (now.isChild(next)) {
                    now = now.findChild(next);
                    continue;
                }
                now.addChild(next);
                now = next;
            }
        }
        print(root, "");
        System.out.println(sb);
    }

    public static void print(Tree now, String line) {
        now.sortChildren();
        for (Tree child : now.children) {
            sb.append(line + child.data + "\n");
            print(child, line + "--");
        }
    }
}
