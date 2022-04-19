class Solution {
    public double average(int[] salary) {
         //check for null input 
        if(salary == null || salary.length ==0)return 0.0;
        
        int sumSalary = 0;
        int maxSalary = salary[0];
        int minSalary = salary[1];
        for(int curr : salary) {
            if(curr< minSalary) {
                minSalary = curr;
            }else if (curr> maxSalary){
                maxSalary = curr;
            }
            sumSalary+= curr;
        }
        return (sumSalary -(maxSalary+minSalary)) /((salary.length -2)*1.0);
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)