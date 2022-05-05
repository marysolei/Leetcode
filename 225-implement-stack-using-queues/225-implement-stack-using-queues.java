class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    //Time complexity of O(n) and space complexity of O(1)
    public void push(int x) {
        q2.add(x);
        top = x;
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    //Time and Space complexity: O(1)
    public int pop() {
        int res = q1.remove();
        if(!q1.isEmpty()) top = q1.peek();
        return res;
    }
    //Time and Space complexity: O(1)
    public int top() {
        return top;
    }
    //Time and Space complexity: O(1)
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */