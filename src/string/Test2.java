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
				
				boolean b=false;	//���ñ��
				
				for(int j=0;j<n;j++){
					if(a[j]%i==0){
						a[j]=a[j]/i;	
						b=true;		
				//ֻҪ��һ�������Ա�i����������Ϊ�棬���ı���Ա��������Ǹ�ֵ���ı��ֵ����				����շת���������һ��
					}
				}
				
				if(b){
					s*=i;	//���Ϊ��˵��շת��������ܼ�������ʹs�۳˱��ϵ���
					i--;
				}
			}
			
			for(int i=0;i<n;i++){
				s*=a[i];	//�ڽ�s�����õ��Ĳ����ټ���շת��������۳�
			}
			
			System.out.println(s);
		}
	}
}