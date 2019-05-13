package algorithm;


public class QuickSort {
	
	public static void main(String[] args) {
		int[] array = createArr(10);
//		int[] array = new int[]{
//				3,5,6,1,2,4
//		};
		System.out.println("快速排序前：");
		printAll(array);
		System.out.println("快速排序前：");
		quickSort(array, 0, array.length - 1);
		printAll(array);
	}
	
	public static void quickSort(int[] array, int left, int right){
		int key = array[left];
		int leftPosition = left;
		int rightPosition = right;
		while(leftPosition < rightPosition){
			while(array[rightPosition] >= key && leftPosition < rightPosition){
				rightPosition --;
			}
			if(rightPosition > leftPosition){
				int temp = array[leftPosition];
				array[leftPosition] = array[rightPosition];
				array[rightPosition] = temp;
			}
			while(array[leftPosition] <= key && leftPosition < rightPosition){
				leftPosition ++;
			}
			if(rightPosition > leftPosition){
				int temp = array[leftPosition];
				array[leftPosition] = array[rightPosition];
				array[rightPosition] = temp;
			}
		}
		if(leftPosition - left > 1){
			quickSort(array, left, leftPosition - 1);
		}
		if(right - rightPosition > 1){
			quickSort(array, rightPosition + 1, right);
		}
			
	}
	
	public static int[] createArr(int num){
		int[] array = new int[num];
		for(int i = 0; i < num; i ++){
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}
	
	public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

}
