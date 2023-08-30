class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        //check for null input 
        if(jewels == null || stones == null)return 0;
        HashSet<Character> jewelSet = new HashSet();
        for(char jewel : jewels.toCharArray()){
            jewelSet.add(jewel);
        }
        int res = 0;
        for(char stone : stones.toCharArray()){
            if(jewelSet.contains(stone)) res++;
        }
        return res;
    }
}
//Time complexity: O(max(s,j))
//space complexity: O(j)