package HuffmanCode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;

/**
 * GOOGLEDOC: https://docs.google.com/document/d/12gql02Qv1YZTXcmkfTesYkv1C1h7sdvRQ6-iKjhr5zc/edit
 * Creates a Map of key / value pairs (key represents the character, value represents its frequency) of a given phrase
 * Creates a HuffmanNode of each key / value pair and sorts them in a PriorityQueue
 * 
 * @author ingrid
 *
 */
public class HuffmanRunner {

	public static void main(String[] args)
	{
		// phrase to use to encode
		String s = "Sally sells sea shells";
		// places k / v pair in Map
		// Key: char
		// Value: frequency
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		ArrayList<Character> listOfKeys = new ArrayList<Character>();
		
		for(int i = 0; i < s.length(); i++)
		{
			if(map.containsKey(s.charAt(i)))
			{
				// increments value of occurrences (by putting new entry and removing old one)
				Character tempKey = s.charAt(i);
				Integer tempVal = map.get(tempKey) + 1;
				
				map.remove(tempKey);
				map.put(tempKey, tempVal); 
			}
			else
			{
				listOfKeys.add(s.charAt(i));
				map.put(s.charAt(i), 1);
			}
		}
		System.out.println("MAP: " + map);
		System.out.println("LIST OF KEYS: " + listOfKeys);
		
		
		// Put HuffmanNodes containing the String and the frequency in PriorityQueue
		PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
		HuffmanNode tempNode;
		for(int i = 0; i < listOfKeys.size(); i++)
		{
			tempNode = new HuffmanNode(Character.toString(listOfKeys.get(i)), map.get(listOfKeys.get(i)));
			queue.add(tempNode);
		}
			
		// to test queue: remove (and print as you remove) and they should be in the correct order
		// WORKS	
		/*
		while(queue.isEmpty() == false)
		{
			System.out.println(queue.poll());
		}*/
		
		// Test ENCODING
		// creates tree using the first HuffmanNode in queue as the root
		HuffmanTree tree = new HuffmanTree(queue.peek());
		tree.encode(queue);
		System.out.println("ENCODED: " + tree.getRoot());
		
		// Test DECODING
		// list values spell "Shells"
		Integer[] tempArray = new Integer[]{1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(Integer i : tempArray)
		{
			list.add(i);
		}
		//System.out.println(list);
		System.out.println("DECODED: " + tree.decode(list));
		
		// list values spell "hey yes"
		Integer[] tempArray1 = new Integer[]{0,1,0,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,0,0,1,1};
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for(Integer i : tempArray1)
		{
			list1.add(i);
		}
		System.out.println("DECODED: " + tree.decode(list1));
		
		// Test HuffmanNode
		/*
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
		System.out.println(node3.compareTo(node2));*/
		
	}
	
}
