package com.algod.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.algod.util.BTreePrinter;
import com.algod.util.TreeNode;

public class BinaryTreeFileSerDeserialization {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<Integer>(2);
		TreeNode<Integer> n3 = new TreeNode<Integer>(3);
		TreeNode<Integer> n4 = new TreeNode<Integer>(4);
		TreeNode<Integer> n5 = new TreeNode<Integer>(5);
		TreeNode<Integer> n6 = new TreeNode<Integer>(6);
		TreeNode<Integer> n7 = new TreeNode<Integer>(7);
		
		n1.left(n2);
		n1.right(n3);
		
		n2.left(n4);
		n2.right(n5);
		
		n4.left(n7);
		
		n3.right(n6);
		
		File f = new File("c://tmp//output.txt");
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
		serialize(n1, os);
		os.writeInt(Integer.MIN_VALUE);
		os.close();
		
		System.out.println("serialized binary tree - ");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream is = new ObjectInputStream(fis);
		while (true) {
			int val = is.readInt();
			if (val == Integer.MIN_VALUE) break;
			System.out.println(val + " ");
		}
		is.close();
		
		is = new ObjectInputStream(new FileInputStream(f));
		
		TreeNode<Integer> n = deserialize(is);
		
		BTreePrinter.printNode(n);
	}
	
	private static void serialize(TreeNode<Integer> n, ObjectOutputStream os) throws IOException {
		if (n == null) {
			os.writeInt(Integer.MAX_VALUE);
			return;
		} else {
			os.writeInt(n.data);
		}
		serialize(n.left, os);
		serialize(n.right, os);
	}

	private static TreeNode<Integer> deserialize(ObjectInputStream is) throws IOException {
		int val = is.readInt();
		if (val == Integer.MIN_VALUE || val == Integer.MAX_VALUE) return null;

		
		TreeNode<Integer> n = new TreeNode<>(val);
		n.left = deserialize(is);
		n.right = deserialize(is);
		return n;
	}

}
