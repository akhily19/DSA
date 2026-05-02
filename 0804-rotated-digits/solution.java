class Solution {
    public int rotatedDigits(int n) {
        int c=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                 c++;
                 }
        }
        return c;}

        private boolean isGood(int num)
        {
            boolean change=false;
            while(num>0)
            {
            int d=num%10;
            if(d==3||d==4||d==7)
            {
                return false;
                }
            else if(d==2||d==5||d==6||d==9)
            {
                change= true;
            }
            num/=10;
            }
            return change;
        }
        
    }

