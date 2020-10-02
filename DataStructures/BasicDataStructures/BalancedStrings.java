package BasicDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedStrings {
    static class Bracket {
        char ch;
        int pos;
        Bracket(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
        boolean matches(char p) {
            if(ch=='(' && p==')') return true;
            if(ch=='{' && p=='}') return true;
            if(ch=='[' && p==']') return true;
            return false;
        }
    }
    static int idx=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(isBalanced(str)) System.out.println("Success");
        else System.out.println(idx);
    }

    public static boolean isBalanced(String str) {
        Stack<Bracket> st = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                st.push(new Bracket(c,i+1));
            else if(c==')' || c=='}' || c==']') {
                if(st.empty()) {
                    idx = i+1;
                    return false;
                }
                Bracket p = st.pop();
                if(!p.matches(c)) {
                    idx=i+1;
                    return false;
                }
            }
        }
        if(!st.empty()) {
            idx=st.pop().pos;
            return false;
        }
        return true;
    }
}
