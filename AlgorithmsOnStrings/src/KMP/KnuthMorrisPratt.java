package KMP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class KnuthMorrisPratt {
    public static List<Integer> findPattern(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String s = pat+"$"+txt;
        int lps[] = new int[s.length()];
        computeLPS(lps, s);
        for (int i=pat.length()+1;i<s.length();i++) {
            if (lps[i] == pat.length())
                result.add(i - (2*pat.length()));
        }
        return result;
    }

    public static void computeLPS(int lps[], String s) {
        int len = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = ++len;
            }
            else if (len != 0) {
                len = lps[len-1];
                --i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pat = br.readLine();
        String txt = br.readLine();
        List<Integer> pos = findPattern(pat, txt);
        for (int i: pos)
            System.out.print(i+" ");
        System.out.println();
    }
}

