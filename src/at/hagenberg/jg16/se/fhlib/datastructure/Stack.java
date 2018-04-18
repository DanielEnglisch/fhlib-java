package at.hagenberg.jg16.se.fhlib.datastructure;

public class Stack<T> {

	private static int DEFAULT_MAX = 10;

	private int top;
	private Object[] data;

	public Stack() {
		this(DEFAULT_MAX);
	}

	public Stack(int max) {
		data = new Object[max];
		top = -1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public boolean isFull() {
		return top >= data.length - 1;
	}

	public void push(T obj) throws StackException {
		if (isFull())
			throw new StackException("Stack is already full!");
		data[++top] = obj;
	}

	@SuppressWarnings("unchecked")
	public T pop() throws StackException {
		if (isEmpty())
			throw new StackException("Stack is already empty!");
		return (T) data[top--];
	}

	@SuppressWarnings("serial")
	public static class StackException extends Exception {

		StackException(String s) {
			super(s);
		}

	}

}
