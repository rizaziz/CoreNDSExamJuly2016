package datastructure;
import java.util.*;
public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		String str="AR, CO, DE, AL, AK, IN, KS, MD, MA, OK, OR";
		Scanner sc=new Scanner(str);
		sc.useDelimiter(", ");

		Queue<String> states=new PriorityQueue<>();
		while(sc.hasNext()){
			states.add(sc.next());
		}

		System.out.println(states.peek());
		System.out.println(states.element());

		states.remove();
		states.poll();

		for(String s:states){
			System.out.print(s+", ");
		}
		System.out.println();

		for(Iterator<String> iter=states.iterator(); iter.hasNext();){
			System.out.print(iter.next()+", ");
		}
		System.out.println();

		Iterator<String> iter=states.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+", ");
		}
		System.out.println();

		System.out.println(states);

	}

}
