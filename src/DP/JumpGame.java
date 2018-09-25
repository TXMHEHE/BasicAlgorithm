package DP;
/**
 *  有n块石头，分别在x轴到的0,1,...n-1位置
 *  一只青蛙在石头0，相跳到石头n-1位置
 *  如果青蛙在第i块石头上，它最多可以向右跳距离ai(i是脚标) --> 注意最多，可以小于
 *  问青蛙是否能跳到石头n-1
 * 
 *  例子：
 *  输入:a=[2,3,1,1,4]
 *  输出:True
 *  输入：a=[3,2,1,0,4]
 *  输出：False
 * 
 *  一、确定状态
 *      最后一步，如果青蛙能跳到最后一块石头n-1（n-1是数组下标）上，则
 *      这一步是从石头i跳过来的，i<n-1:i也是数组下标
 *          则满足：
 *              青蛙可以条到石头i上
 *              最后一步不超过跳跃的最大距离：(n-1)-i<=ai(ai:数组中下标为i的元素)
 *  二、转移方程
 *      f[j]=OR(0<=i<j（OR的下标）)(f[i] and i+a[i]>=j（这里的i，j是数组下标）)
 *      f[j]：是否能跳到石头j上
 *      OR(0<=i<j)：石头j的前一块石头i，青蛙一定能跳到i上，但是i的情况并不确定，可能是第一块石头，也可能是倒数第二快 
 * 
 *  时间复杂度：O(n^2),空间复杂度：O(N)
 * */

 public class JumpGame {
     /**
      * 
      * @param A：石头数组
      * @return
      */
    public boolean conJump(int[] A) {
        if(A == null || A.length == 0) {
            return false;
        }

        int n=A.length;
        boolean[] f=new boolean[n]; //存放最后结果
        f[0]=true;

        for(int j=1;j<n;j++) {

            f[j]=false;

            for(int i=0;i<j;i++) {
                if(f[i] && i+A[i] >= j) {   
                    //解题思想：能跳到石头j，条件：1、必须能跳到石头i；2、i+A[i] >= j
                    //但是算的时候，从j=1往后算，j=0时是初始条件，不用算 
                    
                    //这个问题是求能不能成功，然而解题会出现多种情况，只要一种就可以
                    //问题变种，求最短跳跃次数，则用贪心算法
                    f[j]=true;
                }
            }
        }

        return f[n-1];
    }

    public static void main(String[] args) {
        
    }
 }