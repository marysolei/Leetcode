class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        Arrays.sort(tokens) ;
        int i=0; 
        int j = tokens.length-1;
        int currentPoint= 0; 
        int maxPoint =0;
        
        while(i<=j) {
            if (P>= tokens[i]){
                P-=tokens[i];
                currentPoint++;
                i++;
                maxPoint = Math.max(currentPoint, maxPoint);
            }else if (currentPoint>0) {
                currentPoint--;
                P+= tokens[j];
                j--;
            }else {
                return maxPoint; 
            }
        }
        return maxPoint;
    }
}


//Time Complexity: O(NlogN) because of sorting
//Space Compelxity: O(1) constant time