class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> result = new ArrayList<>();
        //odd value cannot be divided into even numbers
        if(finalSum %2 != 0) return result;
        
        //Greedy approach, bulding the total sum using minimum unique even #s
        long currNum = 2;
        long remainingSum = finalSum;
        
        while(currNum<= remainingSum){
            result.add(currNum);
            remainingSum -= currNum;
            currNum +=2; //next even number
        }
        //now, remaining sum cannot be fulfilled by any larger even number
        //so extract the largest even number we added to the last index of res, and make it even larger by adding this current remaining sum
        //add remaining sum to the last element
        long last = result.remove(result.size()-1);
        result.add(last+remainingSum);
        return result;
    }
}