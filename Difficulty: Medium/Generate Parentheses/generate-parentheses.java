// User function Template for Java

class Solution {

    public ArrayList<String> generateParentheses(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();//final ans
        backtrack(ans,0,0,new StringBuilder(),n/2);
        return ans;
    }
    
    static void backtrack(ArrayList<String> ans, int open, int close, StringBuilder curr, int max){
        if(curr.length()==2*max){//all open and close used
            ans.add(curr.toString());
            return;
        }
        
        //add open
        if(open < max){
            curr.append('(');//add to curr
            backtrack(ans,open+1,close,curr,max);//recursive call
            curr.deleteCharAt(curr.length()-1);//backtrack
        }
        
        //add close
        if(close<open){
            curr.append(')');//add to curr
            backtrack(ans,open,close+1,curr,max);//recursive call
            curr.deleteCharAt(curr.length()-1);
        }
    }
}