package DynamicProgramming2;
import java.util.*;
public class PartitioningSouvenirs {
    static int arr[], subsets[], target;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(util(n-1)?1:0);
    }

    public static boolean util(int index)
    {
        int sum = Arrays.stream(arr).sum();
        int k = 3;
        target = sum/k;
        subsets = new int[k];
        if(arr.length<k || sum%k!=0) return false;
        Arrays.sort(arr);
        if(arr[index]>target) return false;
        while(index>=0 && arr[index]==target) {
            --index; --k;
        }
        return canPartition(index);
    }

    public static boolean canPartition(int index) {
        if(index<0) return true;
        for(int i=0;i<subsets.length;i++) {
            if(subsets[i] + arr[index] <= target) {
                subsets[i] += arr[index];
                if(canPartition(index-1))
                    return true;
                subsets[i] -= arr[index];
            }
            if(subsets[i] == 0)
                break;
        }
        return false;
    }
}