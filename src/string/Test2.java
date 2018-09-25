package string;

import java.util.Scanner;

public class Test2{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int a[]=new int[n];
			int max=0;
			
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				if(a[i]>max){
					max=a[i];
				}
			}
			
			int s=1;
			for(int i=2;i<=max;i++){
				
				boolean b=false;	//设置标记
				
				for(int j=0;j<n;j++){
					if(a[j]%i==0){
						a[j]=a[j]/i;	
						b=true;		
				//只要有一个数可以被i整除就令标记为真，并改变可以被整除的那个值，改变的值将出				现在辗转相除法的下一排
					}
				}
				
				if(b){
					s*=i;	//标记为真说明辗转相除法还能继续；令使s累乘边上的数
					i--;
				}
			}
			
			for(int i=0;i<n;i++){
				s*=a[i];	//在将s与最后得到的不能再继续辗转相除的数累乘
			}
			
			System.out.println(s);
		}
	}
}