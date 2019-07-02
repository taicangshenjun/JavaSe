package course.charper6;

/**
 * λͼ��դ��ͼ���㷨
 * @author cm
 *
 */
public class BitMap {

	//һ��long���ݽṹ�ɴ洢64λ
	private long[] words;
	
	private int size;
	
	public BitMap(int size){
		this.size = size;
		this.words = new long[(getWordIndex(size - 1) + 1)];
	}
	
	/**
	 * ����Ӧ��λ���ó�Ϊ1
	 * @param bitIndex
	 * @return
	 */
	public boolean getBit(int bitIndex) {
		if(bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException("����Bitmap��Ч��Χ��");
		}
		int wordIndex = getWordIndex(bitIndex);
		//java��longһ����64λ��������126λ����ʵ������126-64λ
		return (words[wordIndex] & (1L << bitIndex)) != 0;
	}
	
	/**
	 * �ж�ĳһλ��״̬��1��true��0��false
	 * @param bitIndex
	 */
	public void setBit(int bitIndex) {
		if(bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException("����Bitmap��Ч��Χ��");
		}
		int wordIndex = getWordIndex(bitIndex);
		words[wordIndex] |= (1L << bitIndex);
	}
	
	/**
	 * ��λBitmap���ڵ�word�������е��±�
	 * @param bitIndex
	 * @return
	 */
	public int getWordIndex(int bitIndex) {
		return bitIndex >> 6;
	}
	
	public static void main(String[] args) {
		BitMap bitmap = new BitMap(128);
		bitmap.setBit(126);
		bitmap.setBit(75);
		System.out.println(bitmap.getBit(126));
		System.out.println(bitmap.getBit(78));
	}
	
}
