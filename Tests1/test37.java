package Tests;

import java.util.*;

public class test37 {
    static Map<Long, Boolean> memo = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.close();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            Set<Integer> alice = new HashSet<>();
            Set<Integer> bob = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') alice.add(i + 1);
                else bob.add(i + 1);
            }
            memo.clear();
            boolean res = dfs(alice, bob, true, n);
            System.out.println(res ? "Alice" : "Bob");
        }
    }
    
    static boolean beats(int a, int b, int n) {
        if (a == 1 && b == n) return true;
        if (b == 1 && a == n) return true;
        return a > b;
    }
    
    static long encode(Set<Integer> a, Set<Integer> b, boolean turn) {
        long code = 0;
        for (int x : a) code |= 1L << x;
        for (int x : b) code |= 1L << (x + 50);
        if (turn) code |= 1L << 100;
        return code;
    }
    
    static boolean dfs(Set<Integer> alice, Set<Integer> bob, boolean turn, int n) {
        if (alice.isEmpty()) return false;
        if (bob.isEmpty()) return true;
        long code = encode(alice, bob, turn);
        if (memo.containsKey(code)) return memo.get(code);
        
        boolean res;
        if (turn) { // Alice's turn
            res = false;
            List<Integer> list = new ArrayList<>(alice);
            for (int cardA : list) {
                Set<Integer> newAlice = new HashSet<>(alice);
                newAlice.remove(cardA);
                boolean win = false;
                List<Integer> bobList = new ArrayList<>(bob);
                for (int cardB : bobList) {
                    Set<Integer> newBob = new HashSet<>(bob);
                    newBob.remove(cardB);
                    if (beats(cardA, cardB, n)) {
                        // Alice wins round
                        newAlice.add(cardA);
                        newAlice.add(cardB);
                        if (dfs(newAlice, newBob, true, n)) {
                            win = true;
                            break;
                        }
                    } else {
                        // Bob wins round
                        newBob.add(cardA);
                        newBob.add(cardB);
                        if (!dfs(newAlice, newBob, false, n)) {
                            win = true;
                            break;
                        }
                    }
                }
                if (win) {
                    res = true;
                    break;
                }
            }
        } else { // Bob's turn
            res = true;
            List<Integer> list = new ArrayList<>(bob);
            for (int cardB : list) {
                Set<Integer> newBob = new HashSet<>(bob);
                newBob.remove(cardB);
                boolean lose = false;
                List<Integer> aliceList = new ArrayList<>(alice);
                for (int cardA : aliceList) {
                    Set<Integer> newAlice = new HashSet<>(alice);
                    newAlice.remove(cardA);
                    if (beats(cardB, cardA, n)) {
                        // Bob wins round
                        newBob.add(cardA);
                        newBob.add(cardB);
                        if (!dfs(newAlice, newBob, true, n)) {
                            lose = true;
                            break;
                        }
                    } else {
                        // Alice wins round
                        newAlice.add(cardA);
                        newAlice.add(cardB);
                        if (dfs(newAlice, newBob, false, n)) {
                            lose = true;
                            break;
                        }
                    }
                }
                if (lose) {
                    res = false;
                    break;
                }
            }
        }
        memo.put(code, res);
        return res;
    }
}