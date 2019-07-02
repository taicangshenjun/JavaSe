package course.charper6;

/**
 * 位图（栅格图）算法
 * @author cm
 *
 */
public class BitMap {

	//一个long数据结构可存储64位
	private long[] words;
	
	private int size;
	
	public BitMap(int size){
		this.size = size;
		this.words = new long[(getWordIndex(size - 1) + 1)];
	}
	
	/**
	 * 将对应的位设置成为1
	 * @param bitIndex
	 * @return
	 */
	public boolean getBit(int bitIndex) {
		if(bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException("超过Bitmap有效范围！");
		}
		int wordIndex = getWordIndex(bitIndex);
		//java中long一共有64位，若左移126位，则实际左移126-64位
		return (words[wordIndex] & (1L << bitIndex)) != 0;
	}
	
	/**
	 * 判断某一位的状态，1是true，0是false
	 * @param bitIndex
	 */
	public void setBit(int bitIndex) {
		if(bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException("超过Bitmap有效范围！");
		}
		int wordIndex = getWordIndex(bitIndex);
		words[wordIndex] |= (1L << bitIndex);
	}
	
	/**
	 * 定位Bitmap所在的word在数组中的下标
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
