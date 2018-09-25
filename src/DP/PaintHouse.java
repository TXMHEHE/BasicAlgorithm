package DP;

/**
 * 有一N栋排房子，每栋房子要漆成三种颜色中的一种：红、蓝、绿
 * 任意两栋相邻的房子不能漆成同样的颜色，三种颜色不必全都使用
 * 第i栋房子染成红色、蓝色、绿色的花费分别是cost[i][0]、cost[i][1]、cost[i][2]
 * 问最少需要花多少钱油漆这些房子
 * 
 * f[i][0]=min{f[i-1][1]+cost[i-1][0],f[i-1][2]+cost[i-1][0]}
 * 注：数组f的下标从1开始，cost从0开始
 *     f[i][0]:第i个房子是红色的前提下，粉刷前i栋房子花费最少
 *     f[i-1][1]+cost[i-1][0]/f[i-1][2]+cost[i-1][0]:
 *          第i个房子是红色，那么第i-1个房子是绿色或蓝色
 *          所以需要找到第i-1个房子是绿色或者蓝色中的最小值，并加上第i个房子的价钱即可
 *
 * 对于f[i][0]:第i个房子是红色的，但是我们不一定确定第i个房子一定是红色的
 * 还有f[i][1],f[i][2]
 * 
 *  从后往前想，从前往后算
 *  
 * 初始条件：f[0][0]=f[0][1]=f[0][2]=0
 *      即不油漆任何房子的花费
 * 
 * 计算顺序
 *      初始化f[0][0],f[0][1],f[0][2]
 *       
 *      计算f[1][0],f[1][1],f[1][2]
 *      ...
 *      计算f[N][0],f[N][1],f[N][2] 
 *   
 * 答案是：min{f[N][0],f[N][1],f[N][2]},时间复杂度O(n),空间复杂度O(n)
 */

 public class PaintHouse {

    /**
     * 
     * @param costs:数组，粉刷第i个房子，红色，蓝色。绿色分别花费多少
     * @return
     */
    public int minCost(int[][] costs) {
        int n=costs.length;
        if(n==0) {
            return 0;
        }

        int[][] f=new int[n+1][3];  //用于存放结果

        int i,j,k,res;

        f[0][0]=f[0][1]=f[0][2]=0;

        for(i=1;i<=n;i++) { 
            for(j=0;j<3;j++) {  //第i个房子刷j颜色，花费最少 
                
                f[i][j]=Integer.MAX_VALUE;
                
                for(k=0;k<3;k++) {  //第i个房子刷j颜色，需要知道i-1个房子除j颜色外，哪个颜色花费最少
                    if(j==k) {
                        continue;
                    }

                    if(f[i-1][k]+costs[i-1][j] < f[i][j]) {
                        f[i][j]=f[i-1][k]+costs[i-1][j];
                    }
                }
            }
        }

        res=Math.min(f[n][0],Math.min(f[n][1],f[n][2]));

        return res;
    }

    public static void main(String[] args) {
        
    }
 }