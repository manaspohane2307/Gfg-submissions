// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        Arrays.sort(arr); // Step 1: Sort input array
        int n = arr.length;
        int subsets = 1 << n;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Step 2: Generate all subsets using bitmasking
        for (int i = 0; i < subsets; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }

        // Step 3: Sort the list of subsets lexicographically
        ans.sort((a, b) -> {
            int i = 0;
            while (i < a.size() && i < b.size()) {
                if (!a.get(i).equals(b.get(i))) {
                    return Integer.compare(a.get(i), b.get(i));
                }
                i++;
            }
            return Integer.compare(a.size(), b.size());
        });

        return ans;
    }
}