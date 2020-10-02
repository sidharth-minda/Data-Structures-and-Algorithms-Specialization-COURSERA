package DAGs;
import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInGraph {
    private static int acyclic(ArrayList<Integer>[] adj) {
        for(int i=0;i< adj.length;i++) {
            if(v[i]==0 && dfs(i,adj))
                return 1;
        }
        return 0;
    }
    private static boolean dfs(int idx, ArrayList<Integer>[] adj) {
        v[idx] = 1;
        for(int i=0;i<adj[idx].size();i++) {
            int p = adj[idx].get(i);
            if (v[p] == 1)
                return true;
            if (v[p] == 0 && dfs(p,adj))
                return true;
        }
        v[idx] = -1;
        return false;
    }
    static int v[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        v = new int[n];
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

