package DP;

/**
 * 
 * 给定m行n列的网格，每个格子(i,j)里都有一个非负数A[i][j]
 * 求一个从左上角(0,0)到右下角的路径，每一步只能向下或者向右走一步
 * 使得路径上的格子里的数字之和最小
 * 输出最小数字之和
 * 
 * 一、确定状态
 *  和Unique Path一样，无论用何种方式到达右下角，总有最后一步：
 *      向右或者向下
 *      设右下角坐标设为(m-1.n-1)
 *      那么前一步一定是在(m-2,n-1)或者(m-1,n-2)
 *  最优策略的路径总和数字最小：
 *      若倒数第二步在(m-2,n-1)则前面一定是从(0,0)到达(m-2,n-1)总和最小的路径
 *      若倒数第二步在(m-1,n-2)则前面一定是从(0,0)到达(m-1,n-2)总和最小的路径
 * 
 * 二、转移方程：
 *  f[i][j]=min{f[i-1][j],f[i][j-1]}+A[i][j]
 * 
 * 三、初始条件和边界情况
 *  初始条件：f[0][0]=A[0][0]
 *  边界情况：i=0或j=0，则前一步只能有一个方向过来
 *
 * 最后f[m-1][n-1]存储在f[0][n-1]或f[1][n-1]中  
 */

public class MinimumPathSum {
    public int minPathSum(int[][] A) {

        if(A==null || A.length==0 || A[0].length==0) {
            return 0;
        }

        int m=A.length; //行
        int n=A[0].length;  //列

        int[][] f=new int[2][n];
        int old=1;  //上一次计算的行
        int now=0;  //目前正在计算的行

        int i,j;
        int t1; //相当于f[i-1][j]，存放数据
        int t2; //相当于f[i][j-1]，存放数据

        for(i=0;i<m;i++) {
            old=now;
            now=1-now;

            for(j=0;j<n;j++) {
                if(i==0 && j==0) {  //处理A[0][0]
                    f[now][j]=A[i][j];
                    continue;
                }

                f[now][j]=A[i][j];  //先将A[i][j]存储
                if(i>0) {
                    t1=f[old][j];
                } else {    //当i=0时，f[i-1][j]不存在，所以使用Integer.MAX_VALUE占位
                    t1=Integer.MAX_VALUE;   //因为这时f[i-1][j]不存在；所以t1不能取，所以要使用f[i][j-1]
                }

                if(j>0) {
                    t2=f[now][i-1];
                } else {
                    t2=Integer.MAX_VALUE;
                }

                if(t1<t2) {
                    f[now][j]+=t1;
                } else {
                    f[now][j]+=t2;
                }
            }
        }

        return f[now][n-1];

    }
}