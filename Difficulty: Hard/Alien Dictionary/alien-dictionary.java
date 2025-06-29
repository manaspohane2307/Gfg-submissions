class Solution {
    public String findOrder(String[] words) {
        // code here
        // Step 1: Get all unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
        }

        // Step 2: Build adjacency list and indegree array
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (char c : uniqueChars) {
            adj.put(c, new ArrayList<>());
            indegree.put(c, 0);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            // Edge case: invalid if prefix rule violated
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char u = w1.charAt(j), v = w2.charAt(j);
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        indegree.put(v, indegree.get(v) + 1);
                    }
                    break;
                }
            }
        }

        // Step 3: Topological Sort (Kahn's Algo)
        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            result.append(curr);
            for (char neighbor : adj.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: Check for cycle (incomplete topological sort)
        if (result.length() != uniqueChars.size()) {
            return "";
        }

        return result.toString();
    }
}