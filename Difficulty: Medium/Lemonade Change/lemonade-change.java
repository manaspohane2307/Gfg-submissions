// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int five=0,ten=0;
        for(int i=0;i<N;i++){
            if(bills[i]==5){//5rs
                five++;
            }
            else if(bills[i]==10){//10rs
                if(five>=1){
                    five -= 1;
                    ten += 1;
                }
                else{
                    return false;
                }
            }
            else{//20rs
                if(five>=1 && ten >= 1){
                    five -= 1;
                    ten -= 1;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
