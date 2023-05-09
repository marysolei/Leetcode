class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        if(jewels == null || jewels.length() ==0)return 0;
        HashSet<Character> jSet = new HashSet<>();
        int cnt=0;
        for(char j : jewels.toCharArray()) jSet.add(j);
        for(char s : stones.toCharArray()){
            if(jSet.contains(s)) cnt++;
        }
        return cnt;
    }
}