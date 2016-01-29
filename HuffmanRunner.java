package HuffmanCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * GOOGLEDOC: https://docs.google.com/document/d/12gql02Qv1YZTXcmkfTesYkv1C1h7sdvRQ6-iKjhr5zc/edit
 * 
 * @author ingrid
 *
 */
public class HuffmanRunner {

	public static void main(String[] args)
	{
		
		String s = "Sally sells sea shells";
		// places k / v pair in Map
		// Key: char
		// Value: frequency
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++)
		{
			// 
			if(map.containsKey(s.charAt(i)))
			{
				// increments value of occurences (by putting new entry and removing old one)
				Character tempKey = s.charAt(i);
				Integer tempVal = map.get(tempKey) + 1;
				
				map.remove(tempKey);
				map.put(tempKey, tempVal); 
			}
			else
			{
				map.put(s.charAt(i), 1);
			}
		}
		
		System.out.println(map);
		
		// 
		
		// Test HuffmanNode
		HuffmanNode node = new HuffmanNode(Character.toString('a'), 0);
		
		System.out.println(node.getValue());
		System.out.println(node.getCount());
		System.out.println(node);
		
		HuffmanNode node2 = new HuffmanNode(Character.toString('b'), 1, node, null);
		System.out.println(node2);
		
		HuffmanNode node3 = new HuffmanNode(Character.toString('c'), 1);
		
		// compareTo
		System.out.println(node.compareTo(node2));
		System.out.println(node2.compareTo(node));
		System.out.println(node3.compareTo(node2));
		
	}
	
}
