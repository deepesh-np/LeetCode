class MinStack {
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> list;
    Stack <Integer> s;
    public MinStack() {
        s = new Stack <> ();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        s.push(val);
        min = Math.min(min, val);
        list.add(min);
    }
    
    public void pop() {
        int p = s.pop();
        if (list.get(list.size() - 1) == p){
            list.remove((list.size() - 1));
        }

    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return list.get(list.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */