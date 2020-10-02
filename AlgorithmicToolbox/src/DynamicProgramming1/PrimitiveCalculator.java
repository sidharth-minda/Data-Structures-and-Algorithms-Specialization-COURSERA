package DynamicProgramming1;
import java.util.*;
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(n);
        int dp[] = new int[1000001];
        dp[1]=0;dp[2]=1;dp[3]=1;
        for(int i=4;i<=1000000;i++)
        {
            if(i%3==0)
                dp[i]=1+dp[i/3];
            else {
                dp[i] = dp[i-1] + 1;
                if (i % 2 == 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i/2]);
            }
        }
        while(n!=1)
        {
            if(n%3==0)
                n/=3;
            else if(dp[n]==dp[n-1]+1)
                --n;
            else
                n/=2;
            sequence.add(n);
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (int x : sequence) {
            System.out.print(x + " ");
        }
    }
}


