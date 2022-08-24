class ProductOfNumbers {
    
    List<Integer> arr;
    
    public ProductOfNumbers() {
        arr = new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) {
        if(num>0){
            arr.add(arr.get(arr.size()-1) *num);
        }else{
            arr = new ArrayList<>();
            arr.add(1);
        }
    }
    
    public int getProduct(int k) {
        int n = arr.size();
        return k<n? arr.get(n-1)/arr.get(n-k-1) :0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
//Time complexity: O(1)
//space complexity: O(n)