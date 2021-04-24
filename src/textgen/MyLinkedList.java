package textgen;

import java.util.AbstractList;
import java.lang.*;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.head.prev = null;
		this.tail.prev = this.head;
		this.tail.next = null;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("null is not allowed to be added.");
		}
		LLNode<E> n = new LLNode<E>(element);
		n.prev = this.tail.prev;
		n.prev.next = n;
		//this.tail.prev.next = n;
		n.next = this.tail;
		this.tail.prev = n;
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {
		// TODO: Implement this method.
		String errMsg = "Required index is bigger than list size.";
		if (index < 0) {
			throw new IndexOutOfBoundsException(errMsg);
		}
		LLNode<E> n = new LLNode<E>();
		n = this.head.next;
		for (int i = 0; i <= index; i++) {
			//n = n.next;
			if (n.next == null ) {
				break;
			} else if(n.next != null && i == index) {
				return n.data;
			} 
			n = n.next;
		}
		throw new IndexOutOfBoundsException(errMsg);
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Required index is bigger than list size.");
		}
		if (element == null) {
			throw new NullPointerException("null is not allowed to be added.");
		}
		LLNode<E> nodePrevIndex = new LLNode<E>();
		nodePrevIndex = this.head;
		for (int i = 0; i < index; i++) {
			nodePrevIndex = nodePrevIndex.next;
		}
		LLNode<E> nodeNew = new LLNode<E>(element);
		nodePrevIndex.next.prev = nodeNew;
		nodeNew.next = nodePrevIndex.next;
		nodePrevIndex.next = nodeNew;
		nodeNew.prev = nodePrevIndex;
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		int counter = 0;
		LLNode<E> n = new LLNode<E>();
		n = this.head;
		while(n.next.next != null){
			counter++;
			n = n.next;
		}
		return counter;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Required index is bigger than list size.");
		}
		LLNode<E> nodeAtIndex = new LLNode<E>();
		nodeAtIndex = this.head;
		for (int i = 0; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.next;
		}
		nodeAtIndex.prev.next = nodeAtIndex.next;
		nodeAtIndex.next.prev = nodeAtIndex.prev;
		this.size--;
		return nodeAtIndex.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Required index is bigger than list size.");
		}
		if (element == null) {
			throw new NullPointerException("null is not allowed to be added.");
		}
		LLNode<E> nodeAtIndex = new LLNode<E>();
		nodeAtIndex = this.head;
		for (int i = 0; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.next;
		}
		E nodeData = nodeAtIndex.data;
		nodeAtIndex.data = element;
		return nodeData;
	}   
	
	public String toString() {
		String result = "{ ";
		LLNode<E> nodes = new LLNode<E>();
		nodes = this.head.next;
		for (int i = 0; i < this.size; i++) {
			result = result.concat(nodes.toString() + " ");
			nodes = nodes.next;
		}
		result = result.concat("}");
		return result;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode) 
	{
		this(e, prevNode, prevNode.next);
		//prevNode.next.prev = this;
		//this.next = prevNode.next;
		//prevNode.next = this;
		//this.prev = prevNode;
	}

	public LLNode(E e, LLNode<E> prevNode, LLNode<E> nextNode) 
	{
		this(e);
		prevNode.next = this;
		nextNode.prev = this;
		this.next = nextNode;
		this.prev = prevNode;
	}
	
	public String toString() {
		return "{Data: " + String.valueOf(this.data) + "}"; //+ ", Prev: " + String.valueOf(this.prev) + ", Next: " + String.valueOf(this.next) + "}";
	}
}
