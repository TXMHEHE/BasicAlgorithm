package string;

public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		int x=0;
		int length=0;
		String result=new String();
		
		//获取最短字符串长度
		for(int i=0;i<strs.length;i++) {	
			if(length == 0) {
				length=strs[i].length();
			} else {
				if(length > strs[i].length()) {
					length=strs[i].length();
				}
			}
			
			if(length == 0) {
				return "";
			}
		}
		
		char[][] chs=new char[strs.length][length];
		
		for(String string : strs) {
			
			char[] ch=string.toCharArray();
			
			for(int y=0;y<length;y++) {
				chs[x][y]=ch[y];
			}
			
			x++;
		}
		

		int i=0;
		while(i<length) {	//从左向右
			int flag=0;
			int j;
			for(j=0;j<chs.length-1;j++) {	//从上到下
				if(chs[j][i] != chs[j+1][i]) {
					flag=flag+0;
				}
				if(chs[j][i] == chs[j+1][i]) {
					flag=flag+1;
				}
			}
			
			if(flag == chs.length-1) {
				result=result+String.valueOf(chs[j][i]);
			} else {
				
					return result;
				
			}
			
			i++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		//String string="hehe,haha,hengheng";
		String string="tangxiaoming,hehe,siyax,songge,bowen";
		
		String[] strings=string.split(",");
		
		System.out.println(longestCommonPrefix(strings));
	}
	
}

/*
 * 	运行时间最快的代码
 * 使用了二分法
 * strs[i].startsWith(str1)：判断strs[i]是否以str1开头
 * 使用二分法寻找str1
 class Solution {
    public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}
} 	
 */
