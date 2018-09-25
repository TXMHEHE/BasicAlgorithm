package DP;

/**
 * 给定m行n列的网格，有一个机器人从左上角(0,0)出发，每一步可以向下或者向右走一步，
 * 网格中有些地方有障碍，机器人不能通过障碍格
 * 问有多少种不同的方式走到右下角
 * 
 * f[i][j]=
 *      0，如果(i,j)格有障碍
 *      1，i=0 且 j=0   这是(0,0)位置
 *      1，第一行或第一列（一个方向来的）
 *      f[i-1][j]+f[i][j-1]，其他
 * 
 */

 public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] A) {
        
        int m=A.length;

        if(m == 0) {
            return 0;
        }

        int n=A[0].length;
        if(n == 0) {
            return 0;
        }

        int[][] f=new int[m][n];
        int i,j;
        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {

                if(A[i][j] == 1) {  //A[i][j]有障碍物时，不能到达f[i][j]，所以值为0
                    f[i][j]=0;
                } else {

                    if(i==0 && j==0) {
                        f[i][j]=1;  //设置起始点
                    } else {
                        f[i][j]=0;  //先设置不能到达这个格子

                        //当i>1 && j>1时，两个判断都执行，等价于f[i][j]=f[i-1][j]+f[i][j-1];
                        if(i-1 >= 0) {  //当i=0时，走下一个判断，为f数组第一行赋值
                            f[i][j] += f[i-1][j];
                        }

                        if(j-1 >= 0) {  //当j=0时，走上一个判断，为f数组第一列赋值
                            f[i][j] += f[i][j-1];
                        }

                    }

                }
            }
        }
        
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        
    }
 }