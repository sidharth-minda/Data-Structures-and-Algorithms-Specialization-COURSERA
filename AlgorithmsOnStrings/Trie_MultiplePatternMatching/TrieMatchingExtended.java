package Trie_MultiplePatternMatching;

import java.io.*;
import java.util.*;
public class TrieMatchingExtended implements Runnable {
    static class Node
    {
        public static final int Letters =  4;
        public static final int NA      = -1;
        public int next [];
        public boolean leaf;
        Node ()
        {
            next = new int [Letters];
            Arrays.fill (next, NA);
            leaf = false;
        }
    }
    int letterToIndex (char letter)
    {
        switch (letter)
        {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: assert (false); return Node.NA;
        }
    }

    List <Integer> solve (String text, int n, List <String> patterns) {
        List <Integer> result = new ArrayList <Integer> ();
        List<Node> trie = buildTrie(patterns);
        for (int i=0;i<text.length();i++) {
            int curr = 0;
            for (int j=i;j<text.length();j++) {
                int a = letterToIndex(text.charAt(j));
                if (trie.get(curr).next[a] == -1)
                    break;
                curr = trie.get(curr).next[a];
                if (trie.get(curr).leaf) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    List<Node> buildTrie(List<String> patterns) {
        List<Node> trie = new ArrayList<>();
        trie.add(new Node());
        int m = 0;
        for(int i=0;i<patterns.size();i++) {
            int curr = 0;
            for(int j=0;j<patterns.get(i).length();j++) {
                int a =letterToIndex(patterns.get(i).charAt(j));
                if(trie.get(curr).next[a] != -1)
                    curr = trie.get(curr).next[a];
                else {
                    trie.add(new Node());
                    trie.get(curr).next[a] = ++m;
                    curr = m;
                }
                if (j+1 == patterns.get(i).length())
                    trie.get(curr).leaf = true;
            }
        }
        return trie;
    }

    public void run () {
        try {
            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            String text = in.readLine ();
            int n = Integer.parseInt (in.readLine ());
            List <String> patterns = new ArrayList <String> ();
            for (int i = 0; i < n; i++) {
                patterns.add (in.readLine ());
            }

            List <Integer> ans = solve (text, n, patterns);

            for (int j = 0; j < ans.size (); j++) {
                System.out.print ("" + ans.get (j));
                System.out.print (j + 1 < ans.size () ? " " : "\n");
            }
        }
        catch (Throwable e) {
            e.printStackTrace ();
            System.exit (1);
        }
    }

    public static void main (String [] args) {
        new Thread (new TrieMatchingExtended ()).start ();
    }
}
