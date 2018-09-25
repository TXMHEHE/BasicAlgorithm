package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] arr_N = null;	//n+1到M
		int[] arr_M = null;	//1到M
		
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
				max=array[i];	//先找出这n个数的那个最大的数
			}
		}
		for(int i=max;;i++){
			boolean b=true;	//设置标记
			for(int j=0;j<array.length;j++){
				if(max%array[j]!=0){
					b=false;	
		//只要有一个数不能整除max则令标记为false
				}
			}
			max++;
			if(b){	//如果标记为true说明该max可以整除这n个数
				//则max为最小公倍数
				result=i;
				break;	//跳出循环
			}

		}
		
		return result;
	}
}
