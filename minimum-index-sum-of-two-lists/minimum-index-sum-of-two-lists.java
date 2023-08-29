class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
     
        if(list1 == null || list2 == null)return null;
        HashMap<String, Integer> indexMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<list1.length; i++){
            indexMap.put(list1[i], i);
        }
        for(int j=0;j<list2.length; j++){
            if(indexMap.containsKey(list2[j])){
                sum = j+indexMap.get(list2[j]);
                if(sum<minSum){
                    res.clear();
                    res.add(list2[j]);
                    minSum = sum;
                }else if(sum == minSum){
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

//Time and space complexity: linear