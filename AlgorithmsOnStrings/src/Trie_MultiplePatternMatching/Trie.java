package Trie_MultiplePatternMatching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Trie {
    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();
        int m = 0;
        trie.add(new HashMap<Character, Integer>());
        for(int i=0;i<patterns.length;i++) {
            int curr = 0;
            for(int j=0;j<patterns[i].length();j++) {
                char c = patterns[i].charAt(j);
                if (trie.get(curr).containsKey(c))
                    curr = trie.get(curr).get(c);
                else {
                    trie.add(new HashMap<Character, Integer>());
                    trie.get(curr).put(c, ++m);
                    curr = trie.get(curr).get(c);
                }
            }
        }
        return trie;
    }

    public void print(List<Map<Character, Integer>> trie) {
        for (int i = 0; i < trie.size(); ++i) {
            Map<Character, Integer> node = trie.get(i);
            for (Map.Entry<Character, Integer> entry : node.entrySet()) {
                System.out.println(i + "->" + entry.getValue() + ":" + entry.getKey());
            }
        }
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        print(trie);
    }

    static public void main(String[] args) throws IOException {
        new Trie().run();
    }

    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
