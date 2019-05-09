package interview.sort;

/**
 * 
 * @author cm
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] numArr = SortUtils.createArray();
		SortUtils.showArray(numArr);
		QuickSort.quickSort(numArr, 0, numArr.length - 1);
		SortUtils.showArray(numArr);
	}
	
	public static void quickSort(int[] numArray, int low, int high) {
		int start = low;
		int end = high;
		int key = numArray[start];
		while(start < end) {
			while(start < end && numArray[end] >= key) {
				end --;
			}
			if(start < end) {
				int temp = numArray[end];
				numArray[end] = numArray[start];
				numArray[start] = temp;
			}
			while(start < end && numArray[start] <= key) {
				start ++;
			}
			if(start < end) {
				int temp = numArray[end];
				numArray[end] = numArray[start];
				numArray[start] = temp;
			}
		}
		if(start > low) {
			quickSort(numArray, 0, start - 1);
		}
		if(end > high) {
			quickSort(numArray, start + 1, high);
		}
	}
	
}
