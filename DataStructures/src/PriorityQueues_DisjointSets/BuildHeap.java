package PriorityQueues_DisjointSets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildHeap {
    static class Pair {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static ArrayList<Pair> ans = new ArrayList<>();
    static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        buildHeap(arr);
        System.out.println(count);
        for(Pair p : ans )
            System.out.println(p.a + " " + p.b);
    }

    public static void buildHeap(int arr[]) {
        int n = arr.length;
        for(int i=n/2;i>=0;i--) {
            siftDown(i,arr);
        }
    }

    public static void siftDown(int idx, int arr[]) {
        int minIdx = idx;
        int n = arr.length;
        int left = 2*idx + 1, right = left+1;
        if(left < n && arr[left] < arr[minIdx])
            minIdx = left;
        if(right < n && arr[right] < arr[minIdx])
            minIdx = right;
        if(minIdx == idx)
            return;
        swap(arr, idx, minIdx);
        siftDown(minIdx, arr);
    }

    public static void swap(int arr[], int i, int j)
    {
        ans.add(new Pair(i,j));
        ++count;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
