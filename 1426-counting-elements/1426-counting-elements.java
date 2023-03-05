class Solution {
    public int countElements(int[] arr) {
       if(arr == null || arr.length ==0)return 0;
       HashSet<Integer> hset = new HashSet<>();
       for(int num: arr) hset.add(num);
       int total =0;
       for(int num: arr){
           if(hset.contains(num+1)) total++;
       }
       return total;
    }
}
//time and space complexity: O(n)