package DP;

public class CoinChange {
    /**
     * 
     * @param array:硬币的面值 数组
     * @param value：要拼成的钱数
     * @return
     */

    public int coinChange(int[] array,int value) {
        
        int n=array.length;

        int[] result=new int[value+1];  //0-value
        //result数组：
        //下标代表0-value要拼成的钱数值
        //数组中的值是拼成下标代表的值 用到的硬币最少个数

        int i,j;
        result[0]=0;

        for(i=1;i<=value;i++) {
              
            result[i]=Integer.MAX_VALUE;    //先将值设为正无穷

            //遍历硬币
            for(j=0;j<n;j++) {
                if(i>=array[j] && result[i-array[j]] != Integer.MAX_VALUE && result[i-array[j]]+1 < result[i]) {
                    //数组array：硬币面值大小
                    //数组result：存放最后的结果；下标：要组合出来的值，而数组中存放的是组合出下标值最少的硬币数；
                    //result[16]=3 --> 组合出16，要使用的最少硬币数是3个
                    
                    //i>=array[j]:i是result的下标，代表要拼成的值，必须大于当前硬币的面值
                

                    result[i]=result[i-array[j]]+1;

                }
            }

        }
        
        if(result[value] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result[value];
        }
    }

    public static void main(String[] args) {
        
    }
}