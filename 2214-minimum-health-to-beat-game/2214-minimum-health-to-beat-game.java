class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
        //check for null input 
        if(damage == null || damage.length == 0)return 0;
        int max = 0;
        long health = 1; //health need to be grater than 0 to beat the game at all times
        for(int num : damage) {
            health += num;
            max = Math.max(max, num);
        }
       //To optimally use the armor, we need to use it against the level that causes the most damage.
        health -= Math.min(armor, max);
        return health;
    }
}
//Time complexity: O(n)
//Space complexity: O(1)