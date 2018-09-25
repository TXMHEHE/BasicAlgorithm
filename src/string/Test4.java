package string;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		int[][] array=new int[x][x];
		
		while(sc.hasNext()) {
			int m=sc.nextInt();
			int n=sc.nextInt();
			
			array[m][n]=1;
		}
		
		int max=0;
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<4;j++) {
				int hang=0;
				int lie=0;
				
				if(array[j][i]==1)
					lie++;
				
				if(array[i][j]==1)
					hang++;
				
				if(lie>hang)
					max++;
			}
		}
		
		System.out.println(max);
	}
}
