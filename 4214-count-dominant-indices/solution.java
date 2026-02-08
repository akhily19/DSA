class Solution {
    public int dominantIndices(int[] nums) {
        int n= nums.length;
        if(n<=1)return 0;
        long sum=0;
        for(int x:nums) sum+=x;
        long presum=0;
        int c=0;
        for(int i=0;i<n-1;i++){
            long rightsum=sum-presum-nums[i];
            int rc=n-i-1;
            if((long)nums[i]*rc>rightsum){
                c++;
                
            }
            presum+=nums[i];
        }
            return c;
    }
}
