package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double total = 0;
        Node item[] = new Node[values.length];
        for(int i=0;i<values.length;i++)
        {
            item[i]=new Node(values[i], weights[i]);
        }
        Arrays.sort(item, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.ratio.compareTo(o1.ratio);
            }
        });
        int i=0;
        while(capacity!=0)
        {
            Node n = item[i++];
            if(n.weight<=capacity)
            {
                capacity-=n.weight;
                total+=n.value;
            }
            else
            {
                total+=(n.ratio*capacity);
                capacity=0;
            }
            if(i==values.length)
                break;
        }
        return total;
    }
    static class Node
    {
        int value;
        double weight;
        Double ratio;
        public Node(int value, int weight) {
            this.value=value;
            this.weight=weight;
            ratio=new Double(value/weight);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.format("%.4f",getOptimalValue(capacity, values, weights));
    }
}
