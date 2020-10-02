package ShortestPath;
import java.util.*;
public class Dijkstra {
    static class Node {
        int idx;
        Long dist;
        Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    private static long dijkstra(int src, int dest, ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist.compareTo(o2.dist);
            }
        });
        for (int i=0;i<adj.length;i++)
            pq.add(new Node(i, Long.MAX_VALUE));

        long dist[] = new long[adj.length];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src]=0;
        pq.add(new Node(src, 0));
        while(!pq.isEmpty()) {
            Node u = pq.poll();
            for(int i=0;i<adj[u.idx].size();i++) {
                int v = adj[u.idx].get(i);
                int cst = cost[u.idx].get(i);
                if(dist[u.idx] != Long.MAX_VALUE && dist[v] > dist[u.idx] + cst) {
                    dist[v] = dist[u.idx] + cst;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return dist[dest]==Long.MAX_VALUE?-1:dist[dest];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(dijkstra(x, y, adj, cost));
    }
}


