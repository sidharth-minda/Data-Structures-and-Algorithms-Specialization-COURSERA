package Divide_and_Conquer;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int ans = getCandidate(a);
        int count = (int) Arrays.stream(a).filter(x -> x==ans).count();
        if (count > a.length / 2)
            return 1;
        return -1;
    }

    private static int getCandidate(int[] arr) {
        int ans = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ans)
                ++count;
            else
                --count;
            if (count == 0) {
                ans = arr[i];
                count = 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}