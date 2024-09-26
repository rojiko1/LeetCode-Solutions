package Workspace;
// this is a workspace

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    HashMap<String, ArrayList<List<Integer>>> map;

    public List<List<Integer>> combine(int n, int k) {
        map = new HashMap<>();
        return recur(1, n, k);
    }

    private ArrayList<List<Integer>> recur(int start, int n, int k) {
        String stringified = String.valueOf(start) + " " + String.valueOf(k);
        if (map.containsKey(stringified)) {
            return (ArrayList<List<Integer>>) map.get(stringified).clone();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (k == 1) {
            for (int i = start; i <= n; i++) {
                ArrayList<Integer> elements = new ArrayList<>();
                elements.add(i);
                res.add(elements);
            }
            map.put(stringified, (ArrayList<List<Integer>>) res.clone());
            return res;
        }
        for (int i = start; i <= n - k + 1; i++) {
            ArrayList<List<Integer>> combs = recur(i + 1, n, k - 1);
            for (List<Integer> comb : combs) {
                comb.add(0, i);
                res.add(comb);
            }
        }
        map.put(stringified, (ArrayList<List<Integer>>) res.clone());
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combine(4, 3);
    }



}