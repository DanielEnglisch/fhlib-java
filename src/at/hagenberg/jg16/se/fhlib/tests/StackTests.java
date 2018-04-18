package at.hagenberg.jg16.se.fhlib.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import at.hagenberg.jg16.se.fhlib.datastructure.Stack;
import at.hagenberg.jg16.se.fhlib.datastructure.Stack.StackException;

public class StackTests {

	@Test
	public void emptyTest() throws StackException{
		Stack<String> s = new Stack<>();
		assertTrue(s.isEmpty());
		s.push("Test");
		assertFalse(s.isEmpty());
	}
	
	@Test
	public void pushPopTest() throws StackException{
		String itemIn = "xyz";
		Stack<String> s = new Stack<>();
		assertTrue(s.isEmpty());
		s.push(itemIn);
		String itemOut = s.pop();
		assertEquals(itemIn, itemOut);
	}
	
	@Test(expected = StackException.class)
	public void stackExceptionText() throws StackException{
		Stack<String> s = new Stack<>();
		s.pop();
	}
	
}
