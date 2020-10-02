package DynamicProgramming1;
import java.util.Scanner;
public class MoneyChange {
    private static int getChange(int m) {
        int dp[] = new int[1001];
        dp[1]=1;dp[2]=2;dp[3]=1;dp[4]=1;
        for(int i=5;i<=m;i++)
        {
            dp[i] = Math.min(dp[i-1], Math.min(dp[i-3], dp[i-4])) + 1;
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
