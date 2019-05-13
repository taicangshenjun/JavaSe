package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��Ŀ������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
 * @author cm
 *
 */
public class Test07 {
	
	public static void main(String[] args) {
		String str = "a82bd  +sf8k oeb10*-";
		check1(str);
		check2(str);
	}
	
	public static void check1(String str){
		int count = 0;
		
		String regex = "\\d{1}";
		Pattern pattern = Pattern.compile(regex);
		
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i ++){
			char ch = chars[i];
			Matcher matcher = pattern.matcher(new String(new char[]{ch}));
			if(matcher.matches()){
				count ++;
			}
		}
		System.out.println("���ֹ���" + count);
	}
	
	public static void check2(String str){
		int abccount=0;
		int spacecount=0;
		int numcount=0;
		int othercount=0;
		
		char[] chars = str.toCharArray();
		
		for(int i = 0; i < chars.length; i ++){
			if(Character.isLetter(chars[i])) {
				abccount++;
			}else if(Character.isDigit(chars[i])) {
				numcount++;
			}else if(Character.isSpaceChar(chars[i])){
				spacecount++;
			}else {
				othercount++;
			}
		}
		System.out.println(abccount);
		System.out.println(spacecount);
		System.out.println(numcount);
		System.out.println(othercount);
	}

}
