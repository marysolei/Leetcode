class Solution {
    public boolean isHappy(int n) {
        
      HashSet<Integer> visited = new HashSet<>();
        while(n != 1 && !visited.contains(n)){
            visited.add(n);
            n = getSum(n);
        }
        return n==1;
    }
    public int getSum(int n){
        int sum = 0;
        while(n >0) {
            int digit= n%10;
            sum += digit*digit;
            n/=10;
        }
        return sum;
    }
}

/* Algorithm

There are 2 parts to the algorithm we'll need to design and code.

1) Given a number n, what is its next number?
2) Follow a chain of numbers and detect if we've entered a cycle.

Part 1 can be done by using the division and modulus operators to repeatedly take digits off the number until none remain, and then squaring each removed digit and adding them together. Have a careful look at the code for this, "picking digits off one-by-one" is a useful technique you'll use for solving a lot of different problems.

Part 2 can be done using a HashSet. Each time we generate the next number in the chain, we check if it's already in our HashSet.

- If it is not in the HashSet, we should add it.
- If it is in the HashSet, that means we're in a cycle and so should return false.
*/