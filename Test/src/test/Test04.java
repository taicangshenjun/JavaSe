package test;

import java.util.Scanner;

/**
 * ��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
 * @author cm
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		System.out.println("�����룺");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int result = num;
		String str = "";
		for(int i = 2; i < result / 2 + 1; i ++){
			if(result % i == 0){
				result /= i;
				str += i + "*";
				i = 1;
			}
		}
		if(str.length() > 0){
			str += result + "*";
			str = num + "=" + str.substring(0, str.lastIndexOf("*"));
		}else{
			str = num + "=1*" + num;
		}
		System.out.println(str);
	}
	
}
