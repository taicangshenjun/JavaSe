package test;

/**
 * �ж�101-200֮���ж��ٸ����������������������
 * @author cm
 *
 */
public class Test02 {

	public static void main(String[] args) {
		for(int i = 101; i <= 200; i ++){
			boolean flag = true;
			for(int j = 2; j < i / 2 + 1; j ++){
				if(i % j == 0){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println(i + "������");
			}
		}
	}
	
}
