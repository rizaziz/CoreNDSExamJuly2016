package datastructure;
import java.util.*;
public class UseStack {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Stack that includes push,peek,remove,pop elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		Stack<Double> stack=new Stack<>();

		stack.push(12.25);
		stack.push(1.67);
		stack.push(85d);

		for(int i=0; i<100; i++){
			stack.push(new Random(i).nextDouble());
		}

		System.out.println(stack.pop());

		for(Double d:stack){
			System.out.print(d+", ");
		}
		System.out.println();

		for(Iterator<Double> iter=stack.iterator(); iter.hasNext();){
			System.out.print(iter.next()+", ");
		}
		System.out.println();

		Iterator<Double> iter=stack.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+", ");
		}
		System.out.println();

		System.out.println(stack);
	}

}
