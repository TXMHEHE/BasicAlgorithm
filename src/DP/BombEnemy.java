package DP;

/**
 * 有一个M*N的网格，每个格子可能是空的，可能有一个敌人，可能有一堵墙。
 * 只能在某个空格子里放一个炸弹，炸弹会炸死所有同行同列的敌人，但是不能穿透墙。
 * 最多能炸死几个敌人
 *
 * 在思考和计算的时候， 我们假设有敌人或者有墙的格子也能放炸弹
 *  -有敌人的格子：格子里的敌人被炸死，并继续向上爆炸
 *  -有墙的格子：炸弹不能炸死任何敌人
 * 
 * 在(i,j)格放一个炸弹，它向上能炸死的敌人数是：
 *  -(i,j)格为空地：(i-1,j)格向上能炸死的敌人数
 *  -(i,j)格为敌人：(i-1,j)格向上能炸死的敌人数+1
 *  -(i,j)格为墙：0
 * 
 * 设Up[i][j]表示(i,j)格放一个炸弹向上能炸死的敌人数
 *      Up[i][j]=
 *          Up[i-1][j],如果(i,j)格是空地
 *          Up[i-1][j]+1,如果(i,j)格是敌人
 *          0，如果(i,j)是墙
 * 
 * 初始条件：第0行的Up值和格子内容相关
 *      -Up[0][j]=0:如果(0,j)格不是敌人
 *      -Up[0][j]=1:如果(0,j)格是敌人
 * 计算顺序：
 *      Up[0][0,...,n-1],Up[1][0,...,n-1]....Up[m-1][0,...,n-1]
 * 
 * 一共四个方向
 *      Up[][]，Down[][]，Left[][]，right[][]
 * 
 * (i,j)是空地，放一个炸弹最多炸死的敌人是：
 *      Up[i][j]+Down[i][j]+Left[i][j]+right[i][j]
 * 
 * 注意：当我们取最后的结果时，只会考虑炸弹放在空的格子里的情况。
 *
 */

public class BombEnemy {
    public int maxKilledEnemies(char[][] A) {
        if(A==null || A.length==0 || A[0].length==0) {
            return 0;
        }

        int m=A.length;
        int n=A[0].length;
        int[][] f=new int[m][n];    //存放每一个方向计算后的结果
        int[][] res=new int[m][n];  //存放最后结果
        int i,j;

        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {
                res[i][j]=0;
            }
        }

        //Up方向
        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {
                if(A[i][j]=='W') {  //如果是墙，0
                    f[i][j]=0;
                } else {
                    f[i][j]=0;  //空地，0

                    if(A[i][j]=='E') {
                        f[i][j]=1;  //敌人，1
                    }

                    if(i-1>=0) {   //不是第一行，相加
                        f[i][j]+=f[i-1][j];
                    }
                }

                res[i][j]+=f[i][j]; //每个格子Up方向加入res
            }
        }

        //Down方向
        //Down方向，要从最后一行往(i,j)中的i行计算
        for(i=m-1;i>=0;i--) {
            for(j=0;j<n;j++) {
                if(A[i][j]=='W') {  //如果是墙，0
                    f[i][j]=0;
                } else {
                    f[i][j]=0;  //空地，0

                    if(A[i][j]=='E') {
                        f[i][j]=1;  //敌人，1
                    }

                    if(i+1<m) {   
                        f[i][j]+=f[i+1][j];
                    }
                }

                res[i][j]+=f[i][j]; //每个格子Down方向加入res
            }
        }


        //Left方向
        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {
                if(A[i][j]=='W') {  //如果是墙，0
                    f[i][j]=0;
                } else {
                    f[i][j]=0;  //空地，0

                    if(A[i][j]=='E') {
                        f[i][j]=1;  //敌人，1
                    }

                    if(j-1>=0) {   
                        f[i][j]+=f[i][j-1];
                    }
                }

                res[i][j]+=f[i][j]; //每个格子Left方向加入res
            }
        }

        //Right方向
        for(i=0;i<m;i++) {
            for(j=n-1;j>=0;j--) {
                if(A[i][j]=='W') {  //如果是墙，0
                    f[i][j]=0;
                } else {
                    f[i][j]=0;  //空地，0

                    if(A[i][j]=='E') {
                        f[i][j]=1;  //敌人，1
                    }

                    if(j+1<n) {   
                        f[i][j]+=f[i][j+1];
                    }
                }

                res[i][j]+=f[i][j]; //每个格子Right方向加入res
            }
        }


        int result=0;
        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {
                if(A[i][j] == '0') {
                    if(res[i][j]>result) {
                        result=res[i][j];
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
