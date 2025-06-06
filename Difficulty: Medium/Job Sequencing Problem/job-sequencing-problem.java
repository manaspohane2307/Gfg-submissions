class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        ArrayList<Job> jobs = new ArrayList<>();
        int n = deadline.length;
        for(int i=0;i<n;i++){
            jobs.add(new Job(i+1,deadline[i],profit[i]));
        }
        
        //find maximum deadline
        int max_deadline = 0;
        for(int i=0;i<n;i++){
            max_deadline = Math.max(max_deadline,deadline[i]);
        }
        
        int[] hash = new int[max_deadline+1];
        Arrays.fill(hash,-1);
        
        //sort jobs on basis of profit in descending order
        Collections.sort(jobs, new JobComparator());
        
        int countjobs=0;
        int jobprofit=0;
        for(int i=0;i<n;i++){
            for(int j=jobs.get(i).deadline;j>0;j--){
                if(hash[j]==-1){
                    hash[j] = jobs.get(i).id;
                    countjobs++;
                    jobprofit += jobs.get(i).profit;
                    break;
                }
                
            }
        }
        //ans arraylist
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(countjobs);
        ans.add(jobprofit);
        return ans;
    }
}
class Job{
    int id;
    int deadline;
    int profit;
    Job(int id,int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
class JobComparator implements Comparator<Job>{
    public int compare(Job j1, Job j2){//descending order
        return j2.profit - j1.profit;
    }
}