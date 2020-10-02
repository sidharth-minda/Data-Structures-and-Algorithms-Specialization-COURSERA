package UndirectedGraphs;
import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycle{
    private static int acyclic(ArrayList<Integer>[] adj) {
        for(int i=0;i< adj.length;i++) {
            if(!v[i] && dfs(i, i, adj))
                return 1;
        }
        return 0;
    }
    private static boolean dfs(int idx, int parent, ArrayList<Integer>[] adj) {
        v[idx] = true;
        for(int i=0;i<adj[idx].size();i++) {
            int p = adj[idx].get(i);
            if(v[p] && p!=parent)
                return true;
            if (!v[p] && dfs(p, idx, adj))
                return true;
        }
        return false;
    }
    static boolean v[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        v = new boolean[n];
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y-1].add(x-1);
        }
        System.out.println(acyclic(adj));
    }
}


