package DP;

/**
 * 
 * 有一排N栋房子，每栋房子要漆成K种颜色中的一种
 * 任何两栋相邻的房子不能漆成同样的颜色
 * 房子i染成第j中颜色的花费是cost[i][j]
 * 问最少需要花费多少钱油漆这些房子？
 * 
 * 若要使用以前的解法，有重复计算，时间复杂度O(NK^2)
 * 所以可以优化
 * 
 * 每次要求f[i-1][1],...,f[i-1][k]中除了一个元素之外的其他元素的最小值
 * 
 * 如果最小值是第i个元素，次小值是第j个元素
 *  1、只要除掉的元素不是第i个，剩下的最凶安置就是第i个元素
 *  2、如果除掉的元素是第i个，剩下的最小值就是第j个元素
 * 
 * 记录下f[i-1][1],...,f[i-1][k]中的最小值和次小值分别谁哪个
 * 假如最小值是f[i-1][a],次小值是f[i-1][b]
 * 则对于j=1,2,3,..,a-1,a+1,...,k：f[i][j]=f[i-1][a]+cost[i-1][j]
 *       j=a：f[i][j]=f[i-1][b]+cost[i-1][a]
 * 
 */
public class PaintHouseII {

    public int minCostII(int[][] A) {

        if(A==null || A.length==0) {
            return 0;
        }

        int n=A.length;
        int k=A[0].length;
        int[][] f=new int[n+1][k];  //第一行始终为0
        int min1,min2;  //每行中，最小值min1，第二小的值min2
        int j1=0;
        int j2=0;  //每行中，最小值min1的下标j1，第二小值min2的下标j2
        int i,j;

        //初始化第一行
        for(j=0;j<k;j++) {
            f[0][j]=0;
        }

        //当前行i，寻找i-1行的最小值和第二小值
        for(i=1;i<=n;i++) {

            //每行寻找之前初始化min1，min2
            min1=min2=Integer.MAX_VALUE;

            for(j=0;j<k;j++) {
                if(f[i-1][j]<min1) {    //如果f[i-1][j]比min1小，则min1此时是第二小
                    min2=min1;  //则将min1和min2交换
                    j2=j1;      //同时坐标交换
                    min1=f[i-1][j]; //对min1重新赋值
                    j1=j;           //同时修改坐标j1
                } else {
                    if(f[i-1]][j]<min2) {   //当f[i-1][j]>min1且f[i-1][j]<min2
                        min2=f[i-1][j];
                        j2=j;
                    }
                }
            }

                      
            /**
             * f[i][j]=上一行除了相同颜色的最小值+A[i-1][j]
             *
             * 如果最小值是相同颜色，那就选择第二小的值
             * 如果最小值不是相同颜色，那就选择最小值
             */
            for(j=0;j<k;j++) {
                if(j != j1) {   //最小值 且 不是相同颜色
                    f[i][j]=f[i-1][j1]+A[i-1][j];
                } else {    //最小值 是 相同颜色
                    f[i][j]=f[i-1][j2]+A[i-1][j];
                }
            }
        }

        int result=Integer.MAX_VALUE;
        for(j=0;j<k;j++) {
            result=Math.min(result, f[n][j]);
        }

        return result;
    }


    public static void main(String[] args) {
        
    }
}