package string;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
	
	 public static void main(String[] args) {

		 	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		    Integer temp;
		    int result;	//���ڴ�����Ľ�����������ε�����
		    
	        Scanner sc=new Scanner(System.in);
	        
	        while(true) {
	        	//int i=Integer.parseInt(sc.nextLine());
	        	int i=sc.nextInt();
	        	temp=map.put(i,1);

	            if(temp != null) {
	                map.put(i,++temp);

	                if(temp == 2) {
	                	result=i;
	                	break;
	                }
	            }
	        }
	        
	        System.out.println(result);
	 }
	 
}
