package HashTables;
import java.util.*;
import java.io.*;

public class Longest_Common_Substring_DP {
    public void solve(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];
        int len=0;
        int x=0,y=0;
        for(int i=1;i<=s.length();i++) {
            for(int j=1;j<=t.length();j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > len) {
                        len = dp[i][j];
                        x = i - len;
                        y = j - len;
                    }
                }
            }
        }
        System.out.println(x+" "+y+" "+len);
    }

    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        in.lines().forEach(line -> {
            StringTokenizer tok = new StringTokenizer(line);
            String s = tok.nextToken();
            String t = tok.nextToken();
            solve(s, t);
        });
        out.close();
    }

    static public void main(String[] args) {
        new Longest_Common_Substring_DP().run();
    }
}

