package SpanningTrees;
import java.util.*;
public class Clustering {
    static class Edge {
        int u;
        int v;
        Double dist;
        Edge(int u, int v, double dist) {
            this.u = u;
            this.v = v;
            this.dist= dist;
        }
    }

    private static double clustering(int[] x, int[] y, Edge arr[], int k) {
        int parent[] = new int[x.length];
        int rank[] = new int[x.length];
        for(int i=0;i<x.length;i++)
            makeSet(i, parent);
        Arrays.sort(arr, new Comparator<Edge>() {
            @Override
            public int compare(Edge ob1, Edge ob2) {
                return ob1.dist.compareTo(ob2.dist);
            }
        });
        int count = x.length;
        for(int i=0;i<arr.length;i++) {
            if (union(arr[i].u, arr[i].v, parent, rank)) {
                if(count == k)
                    return arr[i].dist;
                --count;
            }
        }
        return -1.;
    }

    private static void makeSet(int i, int parent[]) {
        parent[i] = i;
    }

    private static int find(int i, int parent[]) {
        if(parent[i] != i)
            parent[i] = find(parent[i], parent);
        return parent[i];
    }

    private static boolean union(int i, int j, int parent[], int rank[]) {
        int a = find(i, parent);
        int b = find(j, parent);
        if(a==b)
            return false;
        if(rank[a] > rank[b])
            parent[b] = a;
        else {
            parent[a] = b;
            if(rank[a] == rank[b])
                ++rank[b];
        }
        return true;
    }

    private static double calcDistance(int i, int j, int x[], int y[]) {
        return Math.sqrt((Math.pow(x[i]-x[j], 2)) + Math.pow((y[i]-y[j]), 2));
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
        int z = 0;
        Edge arr[] = new Edge[(n*(n-1))/2];
        for(int i=0;i<x.length-1;i++) {
            for(int j=i+1;j<x.length;j++) {
                arr[z++] = new Edge(i, j, calcDistance(i, j, x, y));
            }
        }
        int k = scanner.nextInt();
        System.out.println(clustering(x, y, arr, k));
    }
}


