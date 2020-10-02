package Greedy;

import java.util.*;

public class Pisano_Period_NthFibmodM {

    static ArrayList<Integer> pisano;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        pisano= new ArrayList<>();
        pisano.add(0);
        pisano.add(1);
        System.out.println(getFibonacciHuge(n, m));
    }

    private static void pisanoPeriod(long m) {
        long a=0,b=1;
        while(true) {
            long c = (a + b) % m;
            if (c == 0 && (c + b) % m == 1)
                break;
            pisano.add((int) c);
            a = b;
            b = c;
        }
    }

    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;
        pisanoPeriod(m);
        n%=pisano.size();
        return pisano.get((int)n)%m;
    }
}
