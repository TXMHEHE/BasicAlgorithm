package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] arr_N = null;	//n+1��M
		int[] arr_M = null;	//1��M
		
		//Map<Integer,Integer> map=new HashMap<>();
		
		int i=1;
		while(true) {
			int m=n+i;
			
			arr_N=new int[i];
			for(int x=0;x<i;x++) {
				arr_N[x]=n+1+x;
			}
			
			
			arr_M=new int[m];
			for(int y=0;y<m;y++) {
				arr_M[y]=y+1;
			}
			
					
			int result1=method(arr_N);
			int result2=method(arr_M);
			
					
			
			if(result1 == result2) {
				System.out.println(m);
				break;
			} 
			
			if(result1 != result2) {
				arr_N=null;
				arr_M=null;
				i++;
			}			
			
		}
		
	}
	
	public static int method(int[] array) {
		int max=0;
		int result=0;
		for(int i=0;i<array.length;i++){
			if(max<array[i]){
				max=array[i];	//���ҳ���n�������Ǹ�������
			}
		}
		for(int i=max;;i++){
			boolean b=true;	//���ñ��
			for(int j=0;j<array.length;j++){
				if(max%array[j]!=0){
					b=false;	
		//ֻҪ��һ������������max������Ϊfalse
				}
			}
			max++;
			if(b){	//������Ϊtrue˵����max����������n����
				//��maxΪ��С������
				result=i;
				break;	//����ѭ��
			}

		}
		
		return result;
	}
}
