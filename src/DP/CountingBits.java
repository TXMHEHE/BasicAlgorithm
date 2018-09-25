package DP;

/**
 *  给定N，要求输出0,1,2,3,...,N的每个数的二进制表示中1的个数
 * 
 * 最后一步：观察这个数最后一个二进制位（最低位），去掉它，看剩下多少个"1"
 * 
 * 
 * 设f[i]表示i的二进制表示中有多少个"1"
 *  f[i]=f[i>>1]+(i mod 2) 因为二进制的特殊性，f[i>>1]+(i mod 2)才成立
 *  位运算时间复杂度都是一：O(1)
 * 
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 * 
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] f=new int[num+1];

        f[0]=0;

        int i;
        for(i=1;i<=num;i++) {
            f[i]=f[i>>1]+(i%2); 
            //或者f[i]=f[i/2]+(i%2);
            //因为是求i的二进制有多少个"1"，所以i除以2
        }

        return f;
    }
}