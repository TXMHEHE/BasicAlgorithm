package string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * 求一个字符串中，出现最多的字符
 * 
 * map：不允许出现重复的 “键”
 *      put方法：当加入重复的"键"相同的键值对，会把原来的"value"返回
 *               然后插入新的键值对
 *               返回值类型可能是null。所以用包装类来接收
 *
 * 
 */

public class CountChar {
    public static void main(String[] args) {

        HashMap<Character,Integer> map=new HashMap<Character,Integer>();

        Scanner sc=new Scanner(System.in);

        char[] c=sc.nextLine().toCharArray();

        int max=0;
        char maxChar=0;
        Integer temp;

        for(int i=0;i<c.length;i++) {
            temp=map.put(c[i],1);

            if(temp != null) {
                map.put(c[i],++temp);

                if(max < temp) {
                    max=temp;
                    maxChar=c[i];
                }
            }
        }

        System.out.println(maxChar);
        System.out.print(max);

    }
}