class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        //check for null input 
        if(properties == null || properties.length == 0)return 0;
        // Sort in ascending order of attack, 
        // If attack is same, sort in descending order of defense
        Arrays.sort(properties, (a,b) -> (a[0] == b[0])? (b[1]-a[1]) :a[0]-b[0]);
        
        int weakChars = 0;
        int maxDefense = 0;
        for(int i=properties.length -1; i>= 0; i--){
            if(properties[i][1] < maxDefense) weakChars++;
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return weakChars;
    }
}
/*Algorithm
1) Sort the list of pairs properties in ascending order of their attack and then in descending order of the defense value. We can achieve it using the custom comparator.

2) Initialize the maximum defense value achieved maxDefense to 0.

3) Iterate over the pairs from right to left and for each pair:
    a. If the maxDefense is greater than the defense value of the current character, increment the value weakCharacters.

    b. Update the value of maxDefense if it's smaller than the current defense value.
4) Return weakCharacters.*/

//Time complexity O(n logn)
//Space complexity: space used for sorting and inbuild sort() function is O(log n)