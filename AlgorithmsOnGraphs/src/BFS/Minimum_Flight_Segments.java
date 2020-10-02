package BFS;
import java.util.*;
public class Minimum_Flight_Segments {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        return bfs(s, t, adj);
    }

    public static int bfs(int src, int dest, ArrayList<Integer> arr[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int dist[] = new int[arr.length];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        while(!q.isEmpty()) {
            int p = q.poll();
            for(int i=0;i<arr[p].size();i++) {
                int a = arr[p].get(i);
                if(dist[a]==-1) {
                    dist[a] = dist[p] + 1;
                    q.add(a);
                    if(a==dest)
                        return dist[a];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

