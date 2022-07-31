class NumArray {
    
    int[] nums;
    int len;
    int[] block;
    public NumArray(int[] nums) {
        this.nums= nums;
        double l = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length/l);
        block = new int[len];
        for(int i=0; i < nums.length; i++){
            block[i/len] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int block_len = index/len;
        block[block_len] = block[block_len]- nums[index]+val;
        nums[index] =val;
    }
    
    public int sumRange(int left, int right) {
        int sum =0;
        int startBlock = left/len;
        int endBlock = right/len;
        if(startBlock == endBlock) {
            for(int k =left; k<= right; k++) sum+= nums[k];
        }else{
            for (int k = left; k <= (startBlock + 1) * len - 1; k++)
            sum += nums[k];
        for (int k = startBlock + 1; k <= endBlock - 1; k++)
            sum += block[k];
        for (int k = endBlock * len; k <= right; k++)
            sum += nums[k];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */