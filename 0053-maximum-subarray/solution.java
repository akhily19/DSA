class Solution {
    public int maxSubArray(int[] nums) {
        int mSum=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            mSum=Math.max(mSum,sum);

        }
        return mSum;
        
    }
}
