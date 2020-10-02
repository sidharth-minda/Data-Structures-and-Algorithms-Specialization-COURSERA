package Greedy;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int last=0;
        int count=0;
        int arr[] = new int[stops.length+2];
        for(int i=0;i<stops.length;i++)
        {
            arr[i+1]=stops[i];
        }
        arr[stops.length+1]=dist;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i+1]-arr[last]<=tank)
                continue;
            if(i==last)
                return -1;
            last=i;
            ++count;
            --i;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
