class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        if(stones == null || stones.length() ==0) return 0;
        HashSet<Character> jewelSet = new HashSet<>();
        int cnt = 0;
        for(char j: jewels.toCharArray()) jewelSet.add(j);
        for (char stone: stones.toCharArray()){
            if(jewelSet.contains(stone)) cnt++;
        }
        return cnt;
    }
}