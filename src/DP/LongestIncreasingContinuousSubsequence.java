package DP;

/**
 * 
 * 给定a[0],...a[n-1]
 * 找到最长的连续的子序列i,i+1,i+2，..，j，使得a[i]<a[i+1]<...<a[j]
 * 或者a[i]>a[i+1]>...>a[j],输出长度j-i+1
 * 输入：[5,1,2,3,4]
 * 输出4 （子序列1,2,3,4）
 * 
 * 一、确定状态
 *      最后一步：对于（一个子序列）最优策略，一定有最后一个元素a[j]:
 *          1、最优策略中最长连续上升子序列就是{ a[j] },答案就是1
 *          2、子序列长度大于1，那么最优策略中a[j]前一个元素肯定是a[j-1],这种情况一定是a[j-1]<a[j]
 * 二、转移方程
 *      f[j]=以a[j]结尾的最长连续上升子序列的长度
 *          f[j]=max{1,f[j-1]+1（j>0 and a[j-1]<a[j]）}
 *          情况2必须满足：
 *              j>0,即a[j]前面至少还有一个元素
 *              a[j]>a[j-1],满足单调性
 * 
 * 计算f[0],f[1],f[2],...f[n-1],最终答案不是f[n-1],是max(f[0],[1],..,f[n-1])
 * 
 * 时间复杂度：O(n),空间复杂度O(n)
 * 
 * 计算后的结果：
 * array:[5,1,2,3,4,5,1,2,6]
 *     f:[1,1,2,3,4,5,1,2,1]
 *  
 * 空间复杂度为O(1)的解法：          
 *  void calc(int[] A,int n) {
 *       int[] f=new int[2];
 *       int i;
 *       int old;
 *       int now=0;
 *       for(i=0;i<n;i++) {
 *           old=now;
 *           now=1-now;
 *
 *           f[now]=1;
 *
 *           if(i>0 && A[i-1]<A[i]) {
 *               f[now]=f[old]+1;
 *           }
 *
 *            if(f[now]>result) {
 *               result=f[now];
 *           }
 *       }
 *   }
 * 
 */
public class LongestIncreasingContinuousSubsequence {

    int result=0;

    void calc(int[] A,int n) {
        int[] f=new int[n];
        int i;
        for(i=0;i<n;i++) {

            f[i]=1;

            if(i>0 && A[i-1]<A[i]) {
                f[i]=f[i-1]+1;
            }

            if(f[i]>result) {
                result=f[i];
            }
        }
    }

    public int longestincreasingcontinuoussubsequence(int[] A) {
        int n=A.length;

        if(n==0) {
            return 0;
        }

        calc(A,n);

        int i,j,t;
        i=0;
        j=n-1;
        while(i<j) {
            t=A[i];
            A[i]=A[j];
            A[j]=t;
            i++;
            j--;
        }

        calc(A,n);

        return result;

    }
}