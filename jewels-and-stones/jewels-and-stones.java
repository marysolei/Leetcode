class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        //check for null input 
        if(jewels == null || stones == null) return 0;
        HashSet<Character> jewelSet = new HashSet<>();
        int res =0;
        for (char j : jewels.toCharArray()) jewelSet.add(j);
        for(char stone: stones.toCharArray()){
            if(jewelSet.contains(stone)) res++;
        }
        return res;
    }
}
//Time and Space complexity: O(n)