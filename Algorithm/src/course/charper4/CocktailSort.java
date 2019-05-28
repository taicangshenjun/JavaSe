package course.charper4;

import course.util.ArrayUtils;

/**
 * 鸡尾酒排序：
 * 本质是冒泡排序的进阶版，是双向冒泡
 * @author cm
 *
 */
public class CocktailSort {
	
	public static void sort(int[] array) {
		//从右向左找移动最小值，左边界
		int leftIndex = 0;
		//从左向右找移动最大值，右边界
		int rightIndex = array.length - 1;
		for(int i = 0; i < array.length / 2; i ++) {
			//向右冒泡最大值
			boolean flag = true;
			int rightBorderIndex = array.length - 1 - i;
			for(int j = leftIndex; j < rightIndex; j ++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					rightBorderIndex = j;
					flag = false;
				}
			}
			rightIndex = rightBorderIndex;
			if(flag) {
				break;
			}
			
			//向左冒泡最小值
			flag = true;
			int leftBorderIndex = 0;
			for(int j = rightIndex; j > leftIndex; j --) {
				if(array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					leftBorderIndex = j;
					flag = false;
				}
			}
			leftIndex = leftBorderIndex;
			//如果左边界大于等于右边界，数组排列完毕，则退出循环
			if(leftIndex >= rightIndex) {
				flag = true;
			}
			if(flag) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = ArrayUtils.createArray(10);
//		int[] array = new int[] {
//				43,1,12,20,41,84,47,7,20,33
//		};
		ArrayUtils.display(array);
		sort(array);
		ArrayUtils.display(array);
	}

}
