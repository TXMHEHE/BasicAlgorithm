package string;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        
        while(sc.hasNext()) {
        	long n=sc.nextLong();
            
            long num=(long)(Math.sqrt(8.0*n+1.0)-1)/2;
            
            while(num*num+num < (n+1)*2) {
            	num++;
            }
            
            System.out.println(num);
        }
    }
}