class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length];
        for(int i =0;i<nums1.length;i++)
        {
            int copy= nums1[i];
            boolean t=false;
            int g=-1;
            for(int j=0;j<nums2.length;j++)
            {
                if(copy == nums2[j])
                {
                    t=true;
                }
                else if(t&&nums2[j]>copy)
                {
                    g=nums2[j];
                    break;
                }
            }
            arr[i]=g;
         }
         return arr;
    }
}
