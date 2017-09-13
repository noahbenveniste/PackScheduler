package edu.ncsu.csc216.collections.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedListTest {
	
	/**
	 * Unit test for testing the initial creation of a SortedList
	 * @author Kevin Hildner
	 */
	@Test
	public void testSortedList() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
		assertFalse(list.contains("apple"));
		
		//Test that the list grows by adding at least 11 elements
		//Remember the list's initial capacity is 10
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("k");
		assertEquals(11, list.size());
		
		
	}

	/**
	 * Unit test for adding objects to a SortedList
	 * @author Noah Benveniste
	 */
	@Test
	public void testAdd() {
		SortedList<String> list = new SortedList<String>();
		
		list.add("banana");
		assertEquals(1, list.size());
		assertEquals("banana", list.get(0));
		
		//Test adding to the front, middle and back of the list
		list.add("apple");
		assertEquals(2, list.size());
		assertEquals("apple", list.get(0));
		
		list.add("cucumber");
		assertEquals(3, list.size());
		assertEquals("cucumber", list.get(2));
		
		list.add("avocado");
		assertEquals(4, list.size());
		assertEquals("avocado", list.get(1));
		
		//Test adding a null element
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
			assertEquals("apple", list.get(0));
			assertEquals("avocado", list.get(1));
			assertEquals("banana", list.get(2));
			assertEquals("cucumber", list.get(3));
		}
		
		//Test adding a duplicate element
		try {
			list.add("banana");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(4, list.size());
			assertEquals("apple", list.get(0));
			assertEquals("avocado", list.get(1));
			assertEquals("banana", list.get(2));
			assertEquals("cucumber", list.get(3));
		}
	}
	
	/**
	 * Tests edge cases of get() method, including retrieval from empty
	 *   lists, and invalid indeces.
	 * @author Daniel Mills
	 */
	@Test
	public void testGet() {
		SortedList<String> list = new SortedList<String>();
		
		//Since get() is used throughout the tests to check the
		//contents of the list, we don't need to test main flow functionality
		//here.  Instead this test method should focus on the error 
		//and boundary cases.
		
		//Test getting an element from an empty list
		try {
			assertTrue(list.isEmpty());
			list.get(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertTrue(list.isEmpty());
		}
		
		//Add some elements to the list
		list.add("apple");
		list.add("banana");
		list.add("carrot");
		
		
		//Test getting an element at an index < 0
		try {
			assertEquals(3, list.size());
			list.get(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(3, list.size());
		}
		
		//Test getting an element at size
		try {
			assertEquals(3, list.size());
			list.get(list.size());
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(3, list.size());
		}
	}
	
	/**
	 * Tests the remove function of a sorted list
	 * @author Kevin Hildner
	 */
	@Test
	public void testRemove() {
		SortedList<String> list = new SortedList<String>();
		
		//Test removing from an empty list
		try {
			list.remove(0);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		//Add some elements to the list - at least 4
		list.add("apple");
		list.add("banana");
		list.add("carrot");
		list.add("squash");
		//Test removing an element at an index < 0
		try {
			list.remove(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		//TODO Test removing an element at size
		try {
			list.remove(list.size());
			fail();
		} catch(IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}
		//Test removing a middle element
		assertEquals("banana", list.remove(1));
		assertFalse(list.contains("banana"));
		assertEquals(3, list.size());
		//Test removing the last element
		assertEquals("squash", list.remove(3));
		assertFalse(list.contains("squash"));
		assertEquals(2, list.size());
		//Test removing the first element
		assertEquals("apple", list.remove(0));
		assertFalse(list.contains("apple"));
		assertEquals(1, list.size());
		//Test removing the last element
		assertEquals("carrot", list.remove(0));
		assertFalse(list.contains("carrot"));
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testIndexOf() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test indexOf on an empty list
		
		//TODO Add some elements
		
		//TODO Test various calls to indexOf for elements in the list
		//and not in the list
		
		//TODO Test checking the index of null
		
	}
	
	@Test
	public void testClear() {
		SortedList<String> list = new SortedList<String>();

		//TODO Add some elements
		
		//TODO Clear the list
		
		//TODO Test that the list is empty
	}

	@Test
	public void testIsEmpty() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test that the list starts empty
		
		//TODO Add at least one element
		
		//TODO Check that the list is no longer empty
	}

	@Test
	public void testContains() {
		SortedList<String> list = new SortedList<String>();
		
		//TODO Test the empty list case
		
		//TODO Add some elements
		
		//TODO Test some true and false cases
	}
	
	@Test
	public void testEquals() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		
		//TODO Make two lists the same and one list different
		
		//TODO Test for equality and non-equality
	}
	
	@Test
	public void testHashCode() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		
		//TODO Make two lists the same and one list different
		
		//TODO Test for the same and different hashCodes
	}

}
 