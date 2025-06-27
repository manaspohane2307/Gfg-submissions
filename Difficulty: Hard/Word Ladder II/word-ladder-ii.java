// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        HashSet<String> set = new HashSet<>();
        int n = wordList.length;
        for(int i=0;i<n;i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();//initial for level 0
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();//track all words used in a level
        usedOnLevel.add(startWord);
        int level=0;
        
        //arraylist to store result
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int count=0;
        
        //perform bfs
        while(!q.isEmpty()){
            count++;
            ArrayList<String> vec = q.peek();//first sequence that was added
            q.remove();
            //erase all words that were used in previous levels to transorm
            if(vec.size()>level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }
            String word = vec.get(vec.size()-1);//last word of sequnece will be transformed
            if(word.equals(targetWord)){
                if(ans.size()==0){
                    ans.add(vec);
                }
                else if(ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replaced = word.toCharArray();
                    replaced[i] = ch;
                    String replacedword = new String(replaced);
                    if(set.contains(replacedword)){
                        vec.add(replacedword);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will 
                        // remove from everywhere 
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        //mark as visited on level
                        usedOnLevel.add(replacedword);
                        vec.remove(vec.size()-1);
                    }
                }
            }
            
        }
        return ans;
    }
}