package ShortestPath;

import java.util.*;
import java.util.ArrayList;

public class BellmanFord_NegativeCycles {

    private static void bellmanFord(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, long[] distance, int[] reachable, int[] shortest) {
        int n = adj.length;
        distance[s] = 0;
        reachable[s] = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int j = 0; j < adj[u].size(); j++) {
                    int v = adj[u].get(j);
                    int cst = cost[u].get(j);
                    if (distance[u] != Long.MAX_VALUE && distance[v] > distance[u] + cst) {
                        distance[v] = distance[u] + cst;
                        reachable[v] = 1;
                    }
                }
            }
        }
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int u = 0; u < n; u++) {
            for (int j = 0; j < adj[u].size(); j++) {
                int v = adj[u].get(j);
                int cst = cost[u].get(j);
                if (distance[u] != Long.MAX_VALUE && distance[v] > distance[u] + cst) {
                    distance[v] = distance[u] + cst;
                    q.add(v);
                    visited[v] = true;
                    shortest[v]=0;
                }
            }
        }
        bfs(q, adj, shortest, visited);
    }

    private static void bfs(Queue<Integer> q, ArrayList<Integer> arr[], int[] shortest, boolean[] v) {
        while(!q.isEmpty()) {
            int p = q.poll();
            for(int i=0;i<arr[p].size();i++) {
                int a = arr[p].get(i);
                if(!v[a]) {
                    v[a] = true;
                    q.add(a);
                    shortest[a] = 0;
                }
            }
        }
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
        int s = scanner.nextInt() - 1;
        long distance[] = new long[n];
        int reachable[] = new int[n];
        int shortest[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            reachable[i] = 0;
            shortest[i] = 1;
        }
        bellmanFord(adj, cost, s, distance, reachable, shortest);
        for (int i = 0; i < n; i++) {
            if (reachable[i] == 0) {
                System.out.println('*');
            } else if (shortest[i] == 0) {
                System.out.println('-');
            } else {
                System.out.println(distance[i]);
            }
        }
    }

}

