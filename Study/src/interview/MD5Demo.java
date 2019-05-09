package interview;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密流程： 
 * 1. 用户提交用户信息，例如密码； 
 * 2. 服务器收到明文后进行加密（常用的有MD5、SHA等），生成密文； 
 * 3. 服务器将生成的密文存入数据库。 
 * 验证流程： 
 * 1. 用户提交用户信息； 
 * 2. 服务器根据明文生成密文； 
 * 3. 将生成的密文与数据库中的密文进行比对。
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
			System.out.println("md5数组长度 = " + b.length);
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
