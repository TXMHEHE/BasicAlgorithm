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
		//�Ѿ����������ڵ�
		if(t>n-1){
			if(tempValue > maxValue){
				maxValue = tempValue;
				for(int i=0;i<n;i++)
					bestWay[i] = way[i];
			}
			return;
		}
		//������߽ڵ�
		if(tempWeight + weight[t] <= capacity){
			tempWeight += weight[t];
			tempValue += value[t];
			way[t] = 1;
			BackTrack(t+1);
			tempWeight -= weight[t];
			tempValue -= value[t];
			way[t] = 0;
		}
		//��װ�������Ʒ��ֱ�������ұߵĽڵ�
		if( Bound(t+1) >= maxValue){
			BackTrack(t+1);
		}
	}
	//���ڼ���ʣ����Ʒ����߼�ֵ�Ͻ�
	public int Bound(int k){
		int maxLeft = tempValue;
		int leftWeight = capacity - tempWeight;
		//�������յ�λ������ֵ����װʣ�����Ʒ
		while(k <= n-1 && leftWeight > weight[k] ){
			leftWeight -= weight[k];
			maxLeft += value[k];
			k++;
		}
		//����װʱ������һ����Ʒ�ĵ�λ������ֵ���㵽ʣ��ռ䡣
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
