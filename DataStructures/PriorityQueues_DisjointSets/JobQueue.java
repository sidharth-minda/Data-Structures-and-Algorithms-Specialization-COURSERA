package PriorityQueues_DisjointSets;
import java.util.*;
public class JobQueue {
    static class Pair {
        Long thread, time;
        Pair(long thread, long time) {
            this.thread = thread;
            this.time = time;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long t[] = new long[m];
        for(int i=0;i<m;i++)
            t[i] = sc.nextLong();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int x = o1.time.compareTo(o2.time);
                if(x==0)
                    return o1.thread.compareTo(o2.thread);
                return x;
            }
        });
        for(long i=0;i<n;i++)
            pq.add(new Pair(i, 0));
        for(long i: t) {
            Pair p = pq.poll();
            System.out.println(p.thread+" "+p.time);
            pq.add(new Pair(p.thread, p.time + i));
        }
    }
}
