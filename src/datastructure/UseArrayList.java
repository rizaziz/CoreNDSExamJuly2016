package datastructure;

import java.util.*;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */

		List<Integer> list=new ArrayList<>();

		for(Random r=new Random(100); list.size()!=100;){
			list.add(r.nextInt(10000));
		}

		for(int i=0; i<50; i++){
			list.remove(i);
		}

		System.out.println("\n\nIterating with forEach statement....");
		for(int i:list)
			System.out.print(i+", ");

		System.out.println("\n\nIterating with for statement....");
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+", ");

		System.out.println("\n\nIterating with Iterator Object with while statement....");
		Iterator<Integer> iter=list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+", ");

		System.out.println("\n\nIterating with Iterator Object with for statement....");
		for(Iterator<Integer> iterator=list.iterator(); iterator.hasNext();)
			System.out.print(iterator.next()+", ");
	}
}
