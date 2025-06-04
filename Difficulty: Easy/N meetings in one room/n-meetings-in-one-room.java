class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
       ArrayList<Meeting> meet = new ArrayList<>();
       
       for(int i=0;i<start.length;i++){
           meet.add(new Meeting(start[i],end[i],i+1));
       }
       
       MeetingComparator mc = new MeetingComparator();
       Collections.sort(meet,mc);
       
       ArrayList<Integer> ans = new ArrayList<>();
       ans.add(meet.get(0).pos);//add first meeting
       int currend = meet.get(0).end;
       
       for(int i=1;i<start.length;i++){
           if(meet.get(i).start > currend){
               ans.add(meet.get(i).pos);
               currend = meet.get(i).end;
           }
       }
        return ans.size();
    }
}

class Meeting{
    int start;
    int end;
    int pos;
    
    Meeting(int start,int end,int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting>{
    public int compare(Meeting m1, Meeting m2){
        if(m1.end < m2.end) return -1;
        else if(m1.end > m2.end) return 1;
        else if(m1.pos < m2.pos) return -1;
        else return 1;
    }
}
