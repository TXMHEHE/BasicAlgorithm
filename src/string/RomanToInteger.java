package string;

import java.util.Scanner;

public class RomanToInteger {
	
	static int result=0;
	
	public static void toInteger(char[] chs) {
		toInteger(chs,0,chs.length-1);
	}
	
	public static void toInteger(char[] chs,int start,int end) {
		
		if(start > end ) {
			return;
		}
		
		if(chs[start]=='I') {
			if(start == end) {
				result=result+1;
				return;
			}
			
			if(end-start==1) {
				if(chs[start+1]=='V') {
					result=result+4;
					return;
				} else {
					
					if(chs[start+1]=='X') {
						result=result+9;
						return;
					} else {
						
						result=result+1;
						toInteger(chs,start+1,end);
						
					}
				}
			}
			
			if(end-start >= 2) {
				if(chs[start+1]=='v') {
					result=result+4;
					toInteger(chs,start+2,end);
				} else {
					
					if(chs[start+1]=='X') {
						result=result+9;
						toInteger(chs,start+2,end);
					} else {
						
						result=result+1;
						toInteger(chs,start+1,end);
						
					}
				}
			}
		}
		
			
		if(chs[start]=='X') {
			if(start == end) {
				result=result+10;
				return;
			}
			
			if(end-start==1) {
				if(chs[start+1]=='L') {
					result=result+40;
					return;
				} else {
					
					if(chs[start+1]=='C') {
						result=result+90;
						return;
					} else {
						
						result=result+10;
						toInteger(chs,start+1,end);
						
					}
				}
			}
		
			
			if(end-start >= 2) {
				if(chs[start+1]=='L') {
					result=result+40;
					toInteger(chs,start+2,end);
				} else {
					
					if(chs[start+1]=='C') {
						result=result+90;
						toInteger(chs,start+2,end);
					} else {
						
						result=result+10;
						toInteger(chs,start+1,end);
						
					}
				}
			}
		}
		
		if(chs[start]=='C') {
			if(start == end) {
				result=result+100;
				return;
			}
			
			if(end-start==1) {
				if(chs[start+1]=='D') {
					result=result+400;
					return;
				} else {
					
					if(chs[start+1]=='M') {
						result=result+900;
						return;
					} else {
						
						result=result+100;
						toInteger(chs,start+1,end);
						
					}
				}
			}
			
			if(end-start >= 2) {
				if(chs[start+1]=='D') {
					result=result+400;
					toInteger(chs,start+2,end);
				} else {
					
					if(chs[start+1]=='M') {
						result=result+900;
						toInteger(chs,start+2,end);
					} else {
						
						result=result+100;
						toInteger(chs,start+1,end);
						
					}
				}
			}
		}
		
		switch(chs[start]) {
			case 'V':
				result=result+5;
				toInteger(chs,start+1,end);
				break;
			case 'L':
				result=result+50;
				toInteger(chs,start+1,end);
				break;
			case 'D':
				result=result+500;
				toInteger(chs,start+1,end);
				break;
			case 'M':
				result=result+1000;
				toInteger(chs,start+1,end);
				break;
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		String string=null;
		
		Scanner sc=new Scanner(System.in);
		
		string=sc.nextLine();
		
		char[] chs=string.toCharArray();
		
		toInteger(chs);
		
		System.out.println(result);
	}
}
