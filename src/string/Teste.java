package string;

import java.util.Scanner;

public class Teste {
	static int n;
	static int capacity;
	static int[] weight;
	static int[] value;
	int maxValue = 0;
	int tempValue;
	int tempWeight;
	int[] way = new int[n];
	int[] bestWay = new int[n];
	public void BackTrack(int t){
		//已经搜索到根节点
		if(t>n-1){
			if(tempValue > maxValue){
				maxValue = tempValue;
				for(int i=0;i<n;i++)
					bestWay[i] = way[i];
			}
			return;
		}
		//搜索左边节点
		if(tempWeight + weight[t] <= capacity){
			tempWeight += weight[t];
			tempValue += value[t];
			way[t] = 1;
			BackTrack(t+1);
			tempWeight -= weight[t];
			tempValue -= value[t];
			way[t] = 0;
		}
		//不装入这个物品，直接搜索右边的节点
		if( Bound(t+1) >= maxValue){
			BackTrack(t+1);
		}
	}
	//用于计算剩余物品的最高价值上界
	public int Bound(int k){
		int maxLeft = tempValue;
		int leftWeight = capacity - tempWeight;
		//尽力依照单位重量价值次序装剩余的物品
		while(k <= n-1 && leftWeight > weight[k] ){
			leftWeight -= weight[k];
			maxLeft += value[k];
			k++;
		}
		//不能装时，用下一个物品的单位重量价值折算到剩余空间。
		if( k <= n-1){
			maxLeft += value[k]/weight[k]*leftWeight;
		}
		return maxLeft;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		capacity=sc.nextInt();
		
		int x=0;
		
		weight=new int[n];
		value=new int[n];
		
		while(sc.hasNext()) {
			weight[x]=sc.nextInt();	
			System.out.println(weight[x]);
			value[x]=sc.nextInt();
			System.out.println(value[x]);
			x++;
		}
		
		Teste b = new Teste();
		b.BackTrack(0);
		System.out.println(b.maxValue);
	}

}
