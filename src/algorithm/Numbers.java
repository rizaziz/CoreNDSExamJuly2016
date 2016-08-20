package algorithm;
import java.util.Random;
import java.util.*;

public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting.Example in below.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 */

	public static void main(String[] args) {
		
		int [] num = new int[10000];
		
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			
		num[i] = rand.nextInt(1000000);
			
		}

		//Selection Sort
		Sort algo = new Sort();
		algo.selectionSort(num);
		System.out.println(Arrays.toString(algo.selectionSort(num)));
		long selectionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ num.length + " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");

		//Insertion Sort
		algo.insertionSort(num);
		System.out.println(Arrays.toString(algo.insertionSort(num)));
		long insertionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");
		System.out.println(Arrays.equals(algo.insertionSort(num),algo.selectionSort(num)));
		//Continue for rest of the Sorting Algorithm....

		//Bubble Sort
		algo.bubbleSort(num);
		System.out.println(Arrays.toString(algo.bubbleSort(num)));
		long bubbleSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Bubble Sort take: " + bubbleSortExecutionTime + " milli sec");
		System.out.println(Arrays.equals(algo.insertionSort(num),algo.bubbleSort(num)));

		//Bucket Sort
		algo.bucketSort(num);
		System.out.println(Arrays.toString(algo.bucketSort(num)));
		long bucketSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in bucket Sort take: " + bucketSortExecutionTime + " milli sec");
		System.out.println(Arrays.equals(algo.insertionSort(num),algo.bucketSort(num)));


	}

}
