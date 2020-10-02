package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return o1.end.compareTo(o2.end);
            }
        });
        int count=1;
        int end=segments[0].end;
        arr.add(end);
        for(int i=1;i<segments.length;i++)
        {
            if(segments[i].start>end)
            {
                ++count;
                end=segments[i].end;
                arr.add(end);
            }
        }
        int points[] = new int[count];
        for(int i=0;i<count;i++)
        {
            points[i] = arr.get(i);
        }
        return points;
    }

    static class Segment {
    Integer start, end;

    Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

