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
		shortList.add("C");
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
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		//assertEquals("Check third", "C", shortList.get(2));
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//System.out.println(shortList);
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		assertEquals("Check last", "C", shortList.get(shortList.size-1));
		shortList.add("D");
		assertEquals("Check last", "D", shortList.get(shortList.size-1));
		
		try {
			emptyList.add(null);
			fail("Check out of bounds");
		}
		catch (NullPointerException e) {
			
		}
		assertEquals("Check if empty", 0, emptyList.size);
		emptyList.add(55);
		assertEquals("Check if 1 element", 1, emptyList.size);
		assertEquals("Check first element", (Integer)55, emptyList.get(0));
		
		//System.out.println(shortList);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Check if empty", 0, emptyList.size());
		assertEquals("Check longerList", 10, longerList.size());
		assertEquals("Check list1", 3, list1.size());
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
			emptyList.add(0, null);
			fail("Check NullPointerException");
		}
		catch (NullPointerException e) {
			
		}
		try {
			emptyList.add(-1, 1);
			fail("Check IndexOutOfBoundsException");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			emptyList.add(1, 3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.add(4, 22);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		assertEquals("Check at index", "B", shortList.get(1));
		shortList.add(1, "A2");
		assertEquals("Check at index", "A2", shortList.get(1));
		
		shortList.add(4, "E");
		assertEquals("Check at index", "E", shortList.get(4));
		
		shortList.add(0, "1A");
		assertEquals("Check at index", "1A", shortList.get(0));
		System.out.println(shortList);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			shortList.set(0, null);
			fail("Check NullPointerException");
		}
		catch (NullPointerException e) {
			
		}
		
		try {
			emptyList.set(1, 3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(4, 22);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(-1, 22);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		assertEquals("Check at index", "A", shortList.get(0));
		assertEquals("Check at index", "B", shortList.get(1));
		assertEquals("Check at index", "C", shortList.get(2));

		shortList.set(1, "A2");
		assertEquals("Check at index", "A", shortList.get(0));
		assertEquals("Check at index", "A2", shortList.get(1));
		assertEquals("Check at index", "C", shortList.get(2));

	}
	
	
	// TODO: Optionally add more test methods.
	
}
