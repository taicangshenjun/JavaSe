package test;

/**
 * ��Ŀ����������������m��n���������Լ������С��������
 * @author cm
 *
 */
public class Test06 {
	
	public static void main(String[] args) {
		Integer a = 36;
		Integer b = 27;
		Integer maxCommonFactor = getMaxCommonFactor(a, b);
		Integer minMultiple = getMinMultiple(a, b);
		System.out.println("�������Ϊ��" + maxCommonFactor);
		System.out.println("��С������Ϊ��" + minMultiple);
	}
	
	public static Integer getMaxCommonFactor(Integer a, Integer b){
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		Integer maxCommonFactor = null;
		for(int i = 2; i <= a / 2 + 1; i ++){
			if(a % i == 0 && b % i == 0){
				maxCommonFactor = i;
			}
		}
		return maxCommonFactor;
	}
	
	public static Integer getMinMultiple(Integer a, Integer b){
		Integer minMultiple = null;
		Integer maxCommonFactor = getMaxCommonFactor(a, b);
		if(maxCommonFactor != null){
			minMultiple = a * b / maxCommonFactor;
		}else{
			minMultiple = a * b;
		}
		return minMultiple;
	}

}
