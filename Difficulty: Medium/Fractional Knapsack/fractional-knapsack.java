class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        ArrayList<Item> items = new ArrayList<>();
        int n = values.length;
        for(int i=0;i<n;i++){
            items.add(new Item(values[i],weights[i]));
        }
        Collections.sort(items, new ItemComparator());
        int currw = 0;
        double finalval = 0;
        
        for(int i=0;i<n;i++){
            if(currw + items.get(i).weight <= W){
                currw += items.get(i).weight;
                finalval += items.get(i).value;
            }
            else{
                int remain = W - currw;
                finalval += ((double)items.get(i).value / (double)items.get(i).weight)*(double)remain;
                break;
            }
        }
       return finalval; 
    }
}
class Item{
    int value;
    int weight;
    
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}
class ItemComparator implements Comparator<Item>{
    public int compare(Item a, Item b){//descending order
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 > r2){
            return -1;
        }
        else{
            return 1;
        }
    }
}