package interview.sort;

/**
 * ≤Â»Î≈≈–Ú
 * @author cm
 *
 */
public class InserSort {

	public static void main(String[] args) {
		int[] numArray = SortUtils.createArray();
		SortUtils.showArray(numArray);
		sort(numArray);
		SortUtils.showArray(numArray);
	}
	
	public static void sort(int[] numArray) {
		int j;
		for(int i = 1; i < numArray.length; i ++) {
			j = i;
			int key = numArray[i];
			while(j > 0 &&  key < numArray[j - 1]) {
				numArray[j] = numArray[j - 1];
				j --;
			}
			numArray[j] = key;
		}
	}
	
}
