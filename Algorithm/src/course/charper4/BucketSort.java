package course.charper4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import course.util.ArrayUtils;

/**
 * Õ∞≈≈–Ú
 * @author cm
 *
 */
public class BucketSort {
	
	public static double[] sort(double[] array){
		if(array.length < 2){
			return array;
		}
		
		double min = array[0];
		double max = array[0];
		for(int i = 1; i < array.length; i ++){
			if(array[i] < min){
				min = array[i];
			}
			if(array[i] > max){
				max = array[i];
			}
		}
		double diff = (max - min) / (array.length - 1);
		
		ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>();
		for(int i = 0; i < array.length; i ++){
			bucketList.add(new LinkedList<Double>());
		}
		
		for(int i = 0; i < array.length; i ++){
			int index = (int) ((array[i] - min) / diff);
			bucketList.get(index).add(array[i]);
		}
		
		for(int i = 0; i < bucketList.size(); i ++){
			LinkedList<Double> list = bucketList.get(i);
			Collections.sort(list, new Comparator<Double>() {

				@Override
				public int compare(Double o1, Double o2) {
					return o1.doubleValue() > o2.doubleValue()? 1: -1;
				}

			});
		}
		
		double[] result = new double[array.length];
		int resultIndex = 0;
		for(int i = 0; i < bucketList.size(); i ++){
			for(int j = 0; j < bucketList.get(i).size(); j ++){
				result[resultIndex ++] = bucketList.get(i).get(j);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		double[] array = new double[]{
				4.12, 6.421, 10.09, 0.0023, 3.0, 2.123, 8.122, 4.12
		};
		ArrayUtils.display(array);
		sort(array);
		double[] result = sort(array);
		ArrayUtils.display(result);
	}
	
}
