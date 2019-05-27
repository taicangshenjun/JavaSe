package course.charper4;


/**
 * 冒泡排序
 * @author cm
 *
 */
public class BubbleSort {
	
	/**
	 * 冒泡原始算法
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
	 * 优化，当某一次遍历没有交换元素，则证明数组已经有序，则跳出循环
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
	 * 再次改进，如果某个下标之后已经有序，比如3,4,2,1,5,6,7,8
	 * 5之后所有的元素均大于5之前，则3,4,2,1没必要每一次跟5,6,7,8比较
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
