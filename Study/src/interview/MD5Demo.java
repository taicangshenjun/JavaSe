package interview;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * �������̣� 
 * 1. �û��ύ�û���Ϣ���������룻 
 * 2. �������յ����ĺ���м��ܣ����õ���MD5��SHA�ȣ����������ģ� 
 * 3. �����������ɵ����Ĵ������ݿ⡣ 
 * ��֤���̣� 
 * 1. �û��ύ�û���Ϣ�� 
 * 2. ���������������������ģ� 
 * 3. �����ɵ����������ݿ��е����Ľ��бȶԡ�
 * @author cm
 *
 */
public class MD5Demo {

	public static void main(String[] args) {
		encodeMD5("sss");
	}
	
	public static String encodeMD5(String str) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes("UTF-8"));
			byte[] b = md.digest();
			System.out.println("md5���鳤�� = " + b.length);
			dstr = new BigInteger(1, md.digest()).toString(16);
			System.out.println("dstr:" + dstr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return dstr;
	}
	
}
