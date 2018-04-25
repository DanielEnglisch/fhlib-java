package at.hagenberg.jg16.se.fhlib.datastructure;

public interface SortedMultiSet<T extends Comparable<T>> extends Iterable<T> {
	void add(T elem);

	default boolean contains(T elem) {
		return get(elem) != null;
	};

	T get(T elem);

	int size();

	default boolean isEmpty() {
		return size() == 0;
	}
}
