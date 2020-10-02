package ShortestPath;
import java.util.*;
public class DetectNegativeCycle {
    private static int bellmanFord(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        int n = adj.length;
        int dist[] = new int[n];

        for(int i=0;i<n;i++) {
            for(int u=0;u<n;u++) {
                for(int j=0;j<adj[u].size();j++) {
                    int v = adj[u].get(j);
                    int cst = cost[u].get(j);
                    if(dist[v] > dist[u] + cst) {
                        if (i == n - 1)
                            return 1;
                        dist[v] = dist[u] + cst;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        ArrayList<Integer>[] cost = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(bellmanFord(adj, cost));
    }
}


