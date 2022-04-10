class Solution {
    public int calPoints(String[] ops) {
     
        //check for edge cases 
        if (ops == null || ops.length == 0)return 0;
        
        //put everything in a stack
        Stack<Integer> myStack = new Stack<>();
        int result= 0;
        //go over all the strings in ops
        for (String record : ops) {
            //case of +
            if (record.equals("+")) {
                int top = myStack.pop();
                int newValue = top+ myStack.peek();
                myStack.push(top);
                myStack.push(newValue);
                //case of D
            }else if (record.equals("D")) {
                int top = myStack.peek();
                myStack.push(2*top);
                //case of C
            } else if (record.equals("C")) {
                myStack.pop();
            }else {
                myStack.push(Integer.valueOf(record));
            }
        }
        //summation of all values
       for (int value : myStack) {
            result += value;
        }
        return result;
    }
}

//Time and Space Complexity of O(N)