//package HuffmanCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * How Huffman Code works:
 * Given a string, the program generates a Map of key / value pairs containing the frequency of each character and space in the sentence.
 * This data is organized in a PriorityQueue (from least to most occurrences), which is then sorted via Huffman Code
 * Huffman Code: generates a tree where each leaf is a different value. To trace through the tree, use binary code to get to the leafs
 * (0 = left, 1 = right)
 * 
 * @author ingrid
 *
 */
public class HuffmanTree {
	
	private HuffmanNode root;
	
	public HuffmanTree(HuffmanNode n)
	{
		root = n;
	}
	
	
	/**
	 * accessor
	 * @return returns HuffmanNode root
	 */
	public HuffmanNode getRoot()
	{
		return root;
	}

	
	/**
	 * returns root of initialized tree
	 * @param p
	 * @return root, which can be used to access the entire encoded tree
	 */
	public HuffmanNode initializeTree(PriorityQueue<HuffmanNode> p)
	{
		HuffmanNode node1;
		HuffmanNode node2;
		String newKey;
		Integer newVal;
		
		while(p.size() >= 2)
		{
			// poll first two elements in queue and combine them into a new parent node (concatenate string values, add counts)
			// and set left and right pointers of parent node (newNode) to correct children
			node1 = p.poll();
			node2 = p.poll();
			newKey = node1.getValue() + node2.getValue();
			newVal = node1.getCount() + node2.getCount();
			
			HuffmanNode newNode = new HuffmanNode(newKey, newVal, node1, node2);
			
			// place the parent node back in the queue (based on their value)
			p.add(newNode);
			
			// set root to last remaining HuffmanNode in queue
			if(p.size() == 1)
			{
				root = newNode;
			}
		}
		
		return root;
	}
	
	
	/**
	 * encodes String param into an ArrayList based on initialized String
	 * @precondition tree has already been initialized
	 * @precondition is possible to encode given the String used to initialize it
	 * @param toEncode
	 * @return ArrayList<Integer> of param toEncode
	 */
	public ArrayList<Integer> encode(String toEncode)
	{
		ArrayList<Integer> encoded = new ArrayList<Integer>();
		String tempString;
		HuffmanNode tempNode = root;
		
		while(toEncode.length() != 0)
		{
			tempString = toEncode.substring(0,1);
			// check for presence of char (tempString) in left / right nodes. when present, add 0(L) or 1(R) to encoded
			while(tempNode.isLeaf() == false)
			{
				if(tempNode.getLeft().getValue().contains(tempString))
				{
					encoded.add(0);
					tempNode = tempNode.getLeft();
				}
				else if(tempNode.getRight().getValue().contains(tempString))
				{
					encoded.add(1);
					tempNode = tempNode.getRight();
				}
			}
			// keep doing this until isLeaf. then create substring of toEncode w/o first char and reset tempNode to root
			if(tempNode.isLeaf())
			{
				toEncode = toEncode.substring(1);
				tempNode = root;
			}
			 
		}
		
		return encoded;
	}
	
	/**
	 * returns decoded message
	 * @precondition tree has already been initialized
	 * @precondition toDecode contains only binary values
	 * @param toDecode, list of binary with 0 representing left node and 1 representing right node
	 * @return decoded message
	 */
	public String decode(ArrayList<Integer> toDecode)
	{
		String decoded = "";
		HuffmanNode n = root;
		Integer i;
		
		while(toDecode.isEmpty() == false)
		{
			// traverse through tree using values from list until gets to a leaf
			i = toDecode.remove(0);
			// 0 = left node
			if(i.equals(0))
			{
				n = n.getLeft();
				if(n.isLeaf())
				{
					decoded += n.getValue();
					// restart from root of tree
					n = root;
				}
			}
			// 1 = right node
			else
			{
				n = n.getRight();
				if(n.isLeaf())
				{
					decoded += n.getValue();
					n = root;
				}
			}
		}
		return decoded;
	}
}
