class Solution {
    Stack<Long> st = new Stack<Long>();
    Long mini;

    public Solution() {
        mini = Long.MAX_VALUE;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        Long value = Long.valueOf(x);
        if (st.empty()) {
            mini = value;
            st.push(value);
        } else {
            if (value < mini) {
                st.push(2 * value - mini);
                mini = value;
            } else {
                st.push(value);
            }
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (st.empty()) return;
        Long val = st.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if(st.empty()) return -1;
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    // Finds minimum element of Stack
    public int getMin() {
        if(st.empty()) return -1;
        return mini.intValue();
    }

    
}