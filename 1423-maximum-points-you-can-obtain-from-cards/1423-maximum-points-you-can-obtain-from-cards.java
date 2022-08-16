class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        //check for null input 
        if(cardPoints == null || cardPoints.length == 0) return 0;
        
        int n = cardPoints.length;
        int startIndex = 0;
        int totalPoints =0;
        int currPoints =0;
       
        for(int point: cardPoints) totalPoints+= point;
        if(k == n) return totalPoints;
        int minRemaining = totalPoints;
        
        for(int i=0;i<n; i++){
            
            currPoints += cardPoints[i];
            int currLength = i-startIndex+1;
            
            if(currLength == n-k){
                minRemaining = Math.min(minRemaining, currPoints);
                currPoints -= cardPoints[startIndex++];
            }
        }
        return totalPoints-minRemaining;
    }
}
/*we must draw exactly k cards from the array in such a way that the score (sum of the cards) is maximized. After drawing k cards from the array cardPoints.length - k cards will remain in the array.
Another way that we could view the problem is that our objective is to choose cards from the beginning or end of the array in such a way that the sum of the remaining cards is minimized.*/
/*Algorithm

-Find the sum of all cards in the array and store it in a variable totalScore.

- If k is equal to cardPoints.length, then return totalScore.

- Initialize two variables: presentSubarrayScore and startingIndex to 0. This startingIndex marks the starting point of the subarray presently under consideration. Thus it keeps track of the length of the present subarray.

- Initialize a variable minSubarrayScore to totalScore. When the algorithm completes, this variable will hold the smallest possible subarray score in the input array.

- Iterate over the array. At each iteration add the current card to presentSubarrayScore.
- If the size of the subarray under consideration presentSubarrayLength is equal to the requiredSubarrayLength:

        - Compare the score of the subarray presentSubarrayScore with the minSubarrayScore and modify the minSubarrayScore so that it stores the minimum possible subarray sum.
        - Subtract the current card from the presentSubarrayScore.
        - Increment the startingIndex.
- Subtract the minSubarrayScore from the totalScore to get the maximum total score that can be obtained by picking k cards from the beginning or the end of the array. Return this value.

*/