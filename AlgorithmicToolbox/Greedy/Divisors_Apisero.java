package Greedy;

public class Divisors_Apisero {
    static long get(long a, long b, long c)
    {
        if(b>=a)
            return -1;
        c -= b;
        if(c<0)
            return -1;
        long div = c/a;
        return (div * a) + b;
    }

    public static void main(String[] args)
    {
        System.out.print(get(9, 2, 4));
    }
}
