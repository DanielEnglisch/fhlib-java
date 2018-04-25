package at.hagenberg.jg16.se.fhlib.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import at.hagenberg.jg16.se.fhlib.datastructure.BSTMultiSet;
import at.hagenberg.jg16.se.fhlib.datastructure.SortedMultiSet;

public class BSTMultiSetTest {

	@Test
	public void testAdd() {
		SortedMultiSet<Integer> s = new BSTMultiSet<>();
		assertEquals(0, s.size());
		s.add(5);
		assertEquals(1, s.size());
		s.add(1);
		assertEquals(2, s.size());
	}

	@Test
	public void testGet() {
		SortedMultiSet<Integer> s = new BSTMultiSet<>();
		s.add(5);
		s.add(1);
		s.add(2);
		assertEquals(1, s.get(1).intValue());
		assertEquals(2, s.get(2).intValue());
		assertEquals(5, s.get(5).intValue());
		assertNull(s.get(99));
	}

	@Test
	public void testIterator() {
		SortedMultiSet<Integer> s = new BSTMultiSet<>();
		int[] values = { 8, 9, 10, 11 };
		for (int val : values)
			s.add(val);
		Iterator<Integer> it = s.iterator();
		for (int i = 0; i < values.length; ++i) {
			assertTrue(it.hasNext());
			assertEquals(values[i], it.next().intValue());
		}

	}

}
