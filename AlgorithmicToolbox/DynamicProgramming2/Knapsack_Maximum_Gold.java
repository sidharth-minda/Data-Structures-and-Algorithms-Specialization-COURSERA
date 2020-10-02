package DynamicProgramming2;
import java.util.*;

public class Knapsack_Maximum_Gold {
    static int optimalWeight(int W, int[] w) {
        int dp[][] = new int[w.length+1][W+1];
        for(int i=1;i<=w.length;i++)
        {
            for(int j=1;j<=W;j++)
            {
                dp[i][j] = dp[i-1][j];
                if((j-w[i-1]) >= 0)
                    dp[i][j] = Math.max(dp[i][j], w[i-1] + dp[i-1][j-w[i-1]]);
            }
        }
        int i=w.length, j=W;
        while(j>=0 && dp[i][j]==dp[i][W])
            --j;
        return j+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


