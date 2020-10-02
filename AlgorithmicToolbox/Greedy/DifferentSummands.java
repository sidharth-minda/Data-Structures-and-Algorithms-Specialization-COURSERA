package Greedy;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int sum) {
        List<Integer> summands = new ArrayList<Integer>();
        int n=0;
        int i=0;
        while(sum!=0)
        {
            if(sum-(n+1)>=0)
            {
                sum-=(n+1);
                summands.add(n+1);
                ++i;
            }
            else
            {
                summands.set(i-1, n+1);
                --sum;
            }
            ++n;
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

