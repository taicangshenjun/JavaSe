package course.charper6;

/**
 * 位图（栅格图）算法
 * @author cm
 *
 */
public class BitMap {

	private long[] words;
	
	private int size;
	
	public BitMap(int size){
		this.size = size;
		this.words = new long[(getWordIndex(size - 1) + 1)];
	}
	
	public boolean getBit(int bitIndex) {
		if(bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException("超过Bitmap有效范围！");
		}
		int wordIndex = getWordIndex(bitIndex);
		return (words[wordIndex] & (1L << bitIndex)) != 0;
	}
	
	public void setBit(int bitIndex) {
		if(bitIndex < 0 || bitIndex > size - 1) {
			throw new IndexOutOfBoundsException("超过Bitmap有效范围！");
		}
		int wordIndex = getWordIndex(bitIndex);
		words[wordIndex] |= (1L << bitIndex);
	}
	
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
