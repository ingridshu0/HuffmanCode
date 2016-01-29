package HuffmanCode;

/**
 * This HuffmanNode should behave like a normal TreeNode (e.g. have a left and right pointer), except that instead of containing 
 * an Object, it will contain both a Character (named value) and an int (named count). Each should have an accessor and a modifier. 
 * Since you will be placing these HuffmanNodes into a PriorityQueue, they will also have to be Comparable. This comparison should 
 * be based on the value of the int. If the value is the same, the comparison should return equal (0). 
 * @author ingrid
 *
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
	
	HuffmanNode right;
	HuffmanNode left;
	private String value;
	private int count;
	
	public HuffmanNode(String v, int c)
	{
		value = v;
		count = c;
		
		left = null;
		right = null;
	}
	
	public HuffmanNode(String v, int c, HuffmanNode r, HuffmanNode l)
	{
		value = v;
		count = c;
		
		right = r;
		left = l;
	}
	
	// accessors
	/**
	 * returns value of char
	 * @return value of char
	 */
	public String getValue()
	{
		return value;
	}
	
	
	/**
	 * value of count
	 * @return value of count
	 */
	public int getCount()
	{
		return count;
	}
	
	//modifiers
	/**
	 * sets value to c
	 * @param c
	 * @return char that was replaced
	 */
	public String setValue(String c)
	{
		String temp = value;
		value = c;
		
		return temp;
	}
	
	
	/**
	 * sets count to i
	 * @param i
	 * @return previous value of count
	 */
	public int setCount(int i)
	{
		int temp = count;
		count = i;
		
		return temp;
	}
	
	
	/**
	 * sets right node to n
	 * @param n
	 */
	public void setRight(HuffmanNode n)
	{
		right = n;
	}
	
	/**
	 * sets left node to n
	 * @param n
	 */
	public void setLeft(HuffmanNode n)
	{
		left = n;
	}

	/**
	 * compare value of ints of this vs o
	 * returns + int if this value is greater, 0 if values are equal, - int if this value is less
	 * @param o
	 * @return relationship of HuffmanNodes based on their values
	 */
	public int compareTo(HuffmanNode o) {
		return count - o.getCount();
	}
	
	
	/**
	 * returns whether right and left are both null
	 * @return whether right and left are both null
	 */
	public boolean isLeaf()
	{
		return right == null && left == null;
	}
	
	/**
	 * returns String representation of Huffman node and its children
	 * @return String representation of Huffman node and its children
	 */
	public String toString()
	{
		String s = "";
		if(isLeaf())
		{
			s += value;
			return s;
		}
		s += value;
		s += "[";
		if(left != null)
		{
			s += left.toString();
		}
		s += "]";
		s += "[";
		if(right != null)
		{
			s += right.toString();
		}
		s += "]";
		return s;
	}

}
