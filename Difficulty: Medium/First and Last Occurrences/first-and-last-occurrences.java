// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int first = searchFirstOccurence(arr,x);
        int last = searchLastOccurence(arr,x);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(first);
        ans.add(last);
        return ans;
    }
    static int searchFirstOccurence(int[] arr, int target){
        int n = arr.length;
        int low=0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == arr[mid]){
                ans = mid;//maybe an answer
                high = mid-1;//move leftwards to find first occurence
            }
            else if(target < arr[mid]){
                high = mid-1;//move leftwards
            }
            else{
                low = mid+1;//move rightwards
            }
        }
        return ans;
    }

    static int searchLastOccurence(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                ans = mid;// maybe an answer
                low = mid + 1;// move leftwards to find first occurence
            } else if (target < arr[mid]) {
                high = mid - 1;// move leftwards
            } else {
                low = mid + 1;// move rightwards
            }
        }
        return ans;
    }
}
