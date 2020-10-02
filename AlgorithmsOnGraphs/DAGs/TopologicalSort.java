package DAGs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TopologicalSort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean v[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for(int i=1;i<adj.length;i++) {
            if(!v[i])
                dfs(adj, v, order, i);
        }
        Collections.reverse(order);
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] v, ArrayList<Integer> order, int idx) {
        v[idx] = true;
        for(int i=0;i<adj[idx].size();i++) {
            int p = adj[idx].get(i);
            if(!v[p])
                dfs(adj, v, order, p);
        }
        order.add(idx);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x].add(y);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x) + " ");
        }
    }
}

