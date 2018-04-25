package at.hagenberg.jg16.se.fhlib.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTMultiSet<T extends Comparable<T>> implements SortedMultiSet<T> {

	private Node<T> root;
	private int size;

	private static class Node<T> {
		private T data;
		private Node<T> left, right;

		Node(T data) {
			this.data = data;
		}

	}

	private static class BSTMultiSetIterator<T> implements Iterator<T> {

		private Stack<Node<T>> unvisitedParents = new Stack<>();

		public BSTMultiSetIterator(Node<T> root) {
			Node<T> next = root;
			while (next != null) {
				unvisitedParents.push(next);
				next = next.left;
			}

		}

		@Override
		public boolean hasNext() {
			return !unvisitedParents.empty();
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node<T> current = unvisitedParents.pop();
			Node<T> next = current.right;
			while (next != null) {
				unvisitedParents.push(next);
				next = next.left;
			}

			return current.data;

		}

	}

	@Override
	public Iterator<T> iterator() {
		return new BSTMultiSetIterator<T>(root);
	}

	@Override
	public void add(T elem) {
		Node<T> node = new Node<>(elem);
		Node<T> parent = null, tmp = root;

		while (tmp != null) {
			parent = tmp;
			if (elem.compareTo(parent.data) < 0) {
				tmp = tmp.left;
			} else
				tmp = tmp.right;
		}

		/* If tree is empty */
		if (parent == null)
			root = node;
		else if (elem.compareTo(parent.data) < 0)
			parent.left = node;
		else
			parent.right = node;

		++size;

	}

	@Override
	public T get(T elem) {
		Node<T> node = root;
		
		while(node != null) {
			int cmp = node.data.compareTo(elem);
			if(cmp == 0)
				return node.data;
			else if(cmp > 0)
				node = node.left;
			else
				node = node.right;
		}
		
		return null;
	}

	@Override
	public int size() {
		return size;
	}

}
