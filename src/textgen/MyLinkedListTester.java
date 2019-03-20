/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}	
		
		
		// test short list, first contents, then out of bounds
		assertEquals("testGet: check first", "A", shortList.get(0));
		assertEquals("testGet: check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		// TODO: Add more tests here
		try {
			shortList.remove(10);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// TODO: implement this test
		try {
			list1.add(null);
			fail("Check add null value");
		} catch (NullPointerException e) {}
		
		boolean check = list1.add(50);
		assertEquals("testAddEnd: check bool value", true, check);
		int a = list1.get(list1.size() - 1);
		assertEquals("testAddEnd: check if last element added successfully", 50, a);
		assertEquals("testAddEnd: check size", 4, list1.size());
		
		boolean check2 = emptyList.add(1);
		assertEquals("testAddEnd: check bool value", true, check2);
		int b = emptyList.get(emptyList.size - 1);
		assertEquals("testAddEnd: check if last element added successfully", 1, b);
		assertEquals("testAddEnd: check size", 1, emptyList.size);
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("check size : ", 2, shortList.size());
		assertEquals("check size : ", 0, emptyList.size());
		assertEquals("check size : ", 10, longerList.size());
		assertEquals("check size : ", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list1.add(-1, 33);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list1.add(33, 33);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list1.add(1, null);
			fail("Null can't be added");
		} catch (NullPointerException e) {}
		
		list1.add(2, 30);
		assertEquals("testAddEnd: check if element added successfully", (Integer)30, list1.get(2));
		assertEquals("testAddAtIndex: check size", 4, list1.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			list1.set(-1, 33);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list1.set(33, 33);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			list1.set(1, null);
			fail("Null can't be added");
		} catch (NullPointerException e) {}
		
		int a = list1.set(2, 30);
		assertEquals("testSet: check element at index", 30, a);
	}
	
	
	// TODO: Optionally add more test methods.
	
}
