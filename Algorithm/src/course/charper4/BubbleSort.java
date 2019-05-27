package course.charper4;


/**
 * ð������
 * @author cm
 *
 */
public class BubbleSort {
	
	/**
	 * ð��ԭʼ�㷨
	 * @param array
	 */
	public static void sort(int[] array){
		for(int i = array.length - 1; i > 0; i --){
			for(int j = 0; j < i; j ++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
	
	/**
	 * �Ż�����ĳһ�α���û�н���Ԫ�أ���֤�������Ѿ�����������ѭ��
	 * @param array
	 */
	public static void sort2(int[] array){
		for(int i = array.length - 1; i > 0; i --){
			boolean flag = true;
			for(int j = 0; j < i; j ++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = false;
				}
			}
			if(flag){
				break;
			}
		}
	}
	
	/**
	 * �ٴθĽ������ĳ���±�֮���Ѿ����򣬱���3,4,2,1,5,6,7,8
	 * 5֮�����е�Ԫ�ؾ�����5֮ǰ����3,4,2,1û��Ҫÿһ�θ�5,6,7,8�Ƚ�
	 * @param array
	 */
	public static void sort3(int[] array){
		int lastChangeIndex = array.length - 1;
		for(int i = array.length - 1; i > 0; i --){
			boolean flag = true;
			int borderIndex = i;
			for(int j = 0; j < lastChangeIndex; j ++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = false;
					borderIndex = j;
				}
			}
			lastChangeIndex = borderIndex;
			if(flag){
				break;
			}
		}
	}

}
