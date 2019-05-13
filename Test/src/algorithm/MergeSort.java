package algorithm;

import java.util.Arrays;

/**
 * 分治法。
 * 
 * 分治法所能解决的问题一般具有以下几个特征：
 * 1) 该问题的规模缩小到一定的程度就可以容易地解决
 * 2) 该问题可以分解为若干个规模较小的相同问题，即该问题具有最优子结构性质。
 * 3) 利用该问题分解出的子问题的解可以合并为该问题的解；
 * 4) 该问题所分解出的各个子问题是相互独立的，即子问题之间不包含公共的子问题。
 * 
 * 分治法在每一层递归上都有三个步骤：
 * 分解：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题；
 * 解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题；
 * 合并：将各个子问题的解合并为原问题的解。
 * 它的一般的算法设计模式如下：
 * Divide-and-Conquer(P)
 * 1. if |P|≤n0
 * 2. then return(ADHOC(P))
 * 3. 将P分解为较小的子问题 P1 ,P2 ,...,Pk
 * 4. for i←1 to k
 * 5. do yi ← Divide-and-Conquer(Pi) △ 递归解决Pi
 * 6. T ← MERGE(y1,y2,...,yk) △ 合并子问题
 * 7. return(T)
 * 
 * 其中|P|表示问题P的规模；n0为一阈值，表示当问题P的规模不超过n0时，问题已容易直接解出，不必再继续分解。
 * ADHOC(P)是该分治法中的基本子算法，用于直接解小规模的问题P。
 * 因此，当P的规模不超过n0时直接用算法ADHOC(P)求解。
 * 算法MERGE(y1,y2,...,yk)是该分治法中的合并子算法，
 * 用于将P的子问题P1 ,P2 ,...,Pk的相应的解y1,y2,...,yk合并为P的解。
 * 
 * @author cm
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] array = {
                9, 1, 5, 3, 4, 2, 6, 8, 7
        };
		mergeSort(array);
		printAll(array);
	}
	
	public static void mergeSort(int[] array){
		int length = array.length;
		int middle = length / 2;
	 
		if(length > 1){
			int[] left = Arrays.copyOfRange(array, 0, middle);//拷贝数组array的左半部分
			int[] right = Arrays.copyOfRange(array, middle, length);//拷贝数组array的右半部分
			mergeSort(left);//递归array的左半部分
			mergeSort(right);//递归array的右半部分
			merge(array, left, right);//数组左半部分、右半部分合并到Array
		}
	}
	
	private static void merge(int[] result, int[] left, int[] right){
		int i = 0;
		int l = 0;
		int r = 0;
		 
		while(l < left.length && r < right.length){
			if(left[l] < right[r]){
				result[i] = left[l];
				i ++;
				l ++;
			}else{
				result[i] = right[r];
				i ++;
				r ++;
			}
		}
		
		while(r < right.length){//如果右边剩下合并右边的
			result[i] = right[r];
		    r ++;
		    i ++;
		}
		 
		while(l < left.length){
			result[i] = left[l];
		    l ++;
		    i ++;
		}
	}
	
	public static void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
	
}
