class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int answer[][]=new int [matrix.length][];
        for(int i=0;i<matrix.length;i++)
        {
            answer[i]=matrix[i].clone();
        }
        int m= answer.length;
        int n=answer[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(answer[i][j]==-1)
                {
                    int copy=answer[0][j];
                    for(int k=0;k<m;k++)
                    {
                        if(copy<answer[k][j]&&k!=i)
                        {
                            copy=answer[k][j];
                            
                        }
                        answer[i][j]=copy;
                    }
                    
                }
            }
        }

            return answer;
        }
    }

