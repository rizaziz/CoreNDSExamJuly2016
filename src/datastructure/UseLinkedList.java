package datastructure;

import java.util.*;

public class UseLinkedList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use LinkedList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		List<String> list=new LinkedList<>();

		//adding elements to LinkedList///////////////////////////////////////////////////////////////////////////////////////////
		//Using List methods
		list.add("one");
		list.add(1,"two");
		list.addAll(Arrays.asList("three","four","five","six"));
		list.addAll(6, Arrays.asList(new String[]{"seven","eight", "nine"}));

		//Using Queue methods
		((Queue)list).add("ten");
		((Queue)list).offer("eleven");

		//Using Deque methods
		((Deque)list).addFirst("zero");
		((Deque)list).addLast("twelve");
		((Deque)list).offerFirst("-one");
		((Deque)list).offerLast("thirteen");

		//Removing elements from LinkedList///////////////////////////////////////////////////////////////////////////////////////
		//Using List methods
		list.remove("five");
		list.removeAll(Arrays.asList("two", "three", "four"));
		list.remove(3);

		//Using Queue methods
		((Queue) list).element();
		((Queue) list).remove();
		((Queue) list).peek();
		((Queue) list).poll();

		//Using Deque methods
		((Deque)list).getFirst();
		((Deque)list).removeFirst();
		((Deque)list).getLast();
		((Deque)list).removeLast();
		((Deque)list).peekFirst();
		((Deque)list).pollFirst();
		((Deque)list).peekLast();
		((Deque)list).pollLast();

		//Printing LinkedList/////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Content of the list is: "+list);

		//Retreiving elements of the list with loops//////////////////////////////////////////////////////////////////////////////

		System.out.println("\n\nIterating with forEach statement....");
		for(String str:list)
			System.out.print(str+", ");

		System.out.println("\n\nIterating with for statement....");
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+", ");

		System.out.println("\n\nIterating with Iterator Object with while statement....");
		Iterator<String> iter=list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+", ");

		System.out.println("\n\nIterating with Iterator Object with for statement....");
		for(Iterator<String> iterator=list.iterator(); iterator.hasNext();)
			System.out.print(iterator.next()+", ");
	}
}
