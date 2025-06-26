class Solution {
    public int minValue(String s, int k) {
        // code here
        int n = s.length();
        HashMap<Character,Integer> mpp = new HashMap<>();
        for(char c : s.toCharArray()){
            mpp.put(c, mpp.getOrDefault(c,0)+1);
        }
        //goal is to remove character with highest frequency
        for(int i=0;i<k;i++){
            char key = getMaxFrequency(mpp);
            mpp.put(key, mpp.get(key)-1);
        }
        int sum=0;
        for(int freq : mpp.values()){
            sum += freq*freq;
        }
        return sum;
    }
    
    static char getMaxFrequency(HashMap<Character,Integer> mpp){
        int maxfreq = Integer.MIN_VALUE;
        char maxkey=0;
        for(Map.Entry<Character,Integer> entry : mpp.entrySet()){
            if(entry.getValue() > maxfreq){
                maxfreq = entry.getValue();
                maxkey = entry.getKey();
            }
        }
        return maxkey;
    }
}