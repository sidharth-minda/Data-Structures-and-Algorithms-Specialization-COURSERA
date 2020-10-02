package BasicDataStructures;

import java.util.*;
public class MaxSlidingWindow {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int ans[] = maxSlidingWindow(arr, k);
        for(int i: ans)
            System.out.print(i+" ");
    }
    public static int[] maxSlidingWindow(int arr[], int k) {
        int n = arr.length;
        int ans[] = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++) {
            while(!deque.isEmpty() && arr[i]>=arr[deque.peekLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        for(int i=k;i<n;i++) {
            ans[i-k] = arr[deque.peekFirst()];
            while(!deque.isEmpty() && deque.peekFirst() <= i-k)
                deque.pollFirst();
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        ans[n-k] = arr[deque.peekFirst()];
        return ans;
    }
}
