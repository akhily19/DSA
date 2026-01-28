class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int cand=0;
        for(int num: nums)
        {
            if(c==0)
            {
                cand=num;
            }
            if(num==cand){
                c++;
            }
            else{
                c--;
            }
        }
        return cand;
    }
}
