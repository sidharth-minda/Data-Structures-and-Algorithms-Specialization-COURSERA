package SpanningTrees;
import java.util.*;
public class ConnectingPoints {
    static class Edge {
        int u;
        int v;
        Double dist;
        Edge(int u, int v, double dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
    }
    private static double Kruskals(int[] x, int[] y, Edge arr[]) {
        double result = 0d;
        int parent[] = new int[x.length];
        int rank[] = new int[x.length];
        for(int i=0;i<x.length;i++)
            makeSet(i, parent);
        Arrays.sort(arr, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist.compareTo(o2.dist);
            }
        });
        int count=x.length;
        for(int i=0;i<arr.length;i++) {
            if (union(arr[i].u, arr[i].v, parent, rank)) {
                result += arr[i].dist;
                --count;
                if(count ==1)
                    break;
            }
        }
        return result;
    }

    public static void makeSet(int i, int parent[]) {
        parent[i] = i;
    }

    public static int find(int i, int parent[]) {
        if(parent[i] != i)
            parent[i] = find(parent[i], parent);
        return parent[i];
    }

    public static boolean union(int u, int v, int parent[], int rank[]) {
        int a = find(u, parent);
        int b = find(v, parent);
        if(a==b)
            return false;
        if (rank[a] > rank[b])
            parent[b] = a;
        else {
            parent[a] = b;
            if (rank[a] == rank[b])
                ++rank[b];
        }
        return true;
    }

    public static double calcDistance(int a, int b, int x[], int y[]) {
        return Math.sqrt(Math.pow((x[a]-x[b]), 2) + Math.pow((y[a]-y[b]), 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        Edge arr[] = new Edge[(n*(n-1))/2];
        int k = 0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                arr[k++] = new Edge(i, j, calcDistance(i, j, x, y));
            }
        }
        System.out.println(Kruskals(x, y, arr));
    }
}

