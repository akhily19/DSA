import java.util.*;
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> stack=new ArrayList<>();
        for(int x:nums){
            long val=x;
            while(!stack.isEmpty()&&stack.get(stack.size()-1)==val){
                val+=stack.remove(stack.size()-1);
            }
        stack.add(val);
        }
        return stack;
        
    }
    
}
