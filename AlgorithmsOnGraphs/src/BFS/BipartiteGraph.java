package BFS;
import java.util.*;
public class BipartiteGraph {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int v[] = new int[adj.length];
        Arrays.fill(v, -1);
        for(int i=0;i<adj.length;i++) {
            if(v[i]==-1 && !bfs(i, adj, v))
                return 0;
        }
        return 1;
    }

    private static boolean bfs(int idx, ArrayList<Integer>[] adj, int v[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        v[idx] = 0;
        while(!q.isEmpty()) {
            int p = q.poll();
            for(int i=0;i<adj[p].size();i++) {
                int a = adj[p].get(i);
                if(v[a] == v[p])
                    return false;
                if(v[a]==-1) {
                    v[a] = (v[p]+1)%2;
                    q.add(a);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

