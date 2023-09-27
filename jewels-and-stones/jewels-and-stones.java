class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        //check for null input 
        if(jewels == null || stones == null)return 0;
        int res =0;
        HashSet<Character> jewelSet = new HashSet<>();
        for(char j: jewels.toCharArray()) jewelSet.add(j);
        for(char s: stones.toCharArray()){
            if(jewelSet.contains(s)) res++;
        }
        return res;
    }
}
//Time complexity:Max(J, S)
//space complexity: J