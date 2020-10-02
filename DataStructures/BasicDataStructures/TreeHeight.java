package BasicDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeHeight {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int parent[] = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<Integer> arr[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            arr[i] = new ArrayList<>();
        int root = 0;
        for(int i=0;i<n;i++) {
            if(parent[i]==-1)
                root = i;
            else
                arr[parent[i]].add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        q.add(-1);
        int height = 1;
        while (q.size()>1) {
            int p =q.poll();
            if(p==-1) {
                q.add(-1);
                ++height;
                continue;
            }
            for(int i=0;i<arr[p].size();i++) {
                q.add(arr[p].get(i));
            }
        }
        System.out.println(height);
    }
}
