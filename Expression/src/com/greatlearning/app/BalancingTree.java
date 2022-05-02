package com.greatlearning.app;

import java.util.HashSet;

public class BalancingTree {
	
	static class Node {
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static boolean traversal(Node node, int sum, HashSet<Integer> set) {
		if(node == null) {
			return false;
		}
		if(traversal(node.left, sum, set)) {
			return true;
		}
		if(set.contains(sum - node.data)) {
			System.out.println("Pair already exists");
			return true;
		} else {
			set.add(node.data);
		}	
		System.out.print(node.data);
		if(traversal(node.right,sum, set)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		HashSet<Integer> iteration = new HashSet<Integer>();
		int sum = 60;
		Node root = new Node(40);
		Node left = new Node(20);
		Node right = new Node(60);
		root.left = left;
		root.right = right;
		boolean binarySearch = traversal(root, sum, iteration);
		if(!binarySearch) {
			System.out.println("Pair does not exist");
		}
	}

}
