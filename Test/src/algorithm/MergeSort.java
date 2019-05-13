package algorithm;

import java.util.Arrays;

/**
 * ���η���
 * 
 * ���η����ܽ��������һ��������¼���������
 * 1) ������Ĺ�ģ��С��һ���ĳ̶ȾͿ������׵ؽ��
 * 2) ��������Էֽ�Ϊ���ɸ���ģ��С����ͬ���⣬����������������ӽṹ���ʡ�
 * 3) ���ø�����ֽ����������Ľ���Ժϲ�Ϊ������Ľ⣻
 * 4) ���������ֽ���ĸ������������໥�����ģ���������֮�䲻���������������⡣
 * 
 * ���η���ÿһ��ݹ��϶����������裺
 * �ֽ⣺��ԭ����ֽ�Ϊ���ɸ���ģ��С���໥��������ԭ������ʽ��ͬ�������⣻
 * ��������������ģ��С�����ױ������ֱ�ӽ⣬����ݹ�ؽ���������⣻
 * �ϲ���������������Ľ�ϲ�Ϊԭ����Ľ⡣
 * ����һ����㷨���ģʽ���£�
 * Divide-and-Conquer(P)
 * 1. if |P|��n0
 * 2. then return(ADHOC(P))
 * 3. ��P�ֽ�Ϊ��С�������� P1 ,P2 ,...,Pk
 * 4. for i��1 to k
 * 5. do yi �� Divide-and-Conquer(Pi) �� �ݹ���Pi
 * 6. T �� MERGE(y1,y2,...,yk) �� �ϲ�������
 * 7. return(T)
 * 
 * ����|P|��ʾ����P�Ĺ�ģ��n0Ϊһ��ֵ����ʾ������P�Ĺ�ģ������n0ʱ������������ֱ�ӽ���������ټ����ֽ⡣
 * ADHOC(P)�Ǹ÷��η��еĻ������㷨������ֱ�ӽ�С��ģ������P��
 * ��ˣ���P�Ĺ�ģ������n0ʱֱ�����㷨ADHOC(P)��⡣
 * �㷨MERGE(y1,y2,...,yk)�Ǹ÷��η��еĺϲ����㷨��
 * ���ڽ�P��������P1 ,P2 ,...,Pk����Ӧ�Ľ�y1,y2,...,yk�ϲ�ΪP�Ľ⡣
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
			int[] left = Arrays.copyOfRange(array, 0, middle);//��������array����벿��
			int[] right = Arrays.copyOfRange(array, middle, length);//��������array���Ұ벿��
			mergeSort(left);//�ݹ�array����벿��
			mergeSort(right);//�ݹ�array���Ұ벿��
			merge(array, left, right);//������벿�֡��Ұ벿�ֺϲ���Array
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
		
		while(r < right.length){//����ұ�ʣ�ºϲ��ұߵ�
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
