package math;

/**
 * Created by mrahman on 4/9/16.
 */
public class FindMissingNumber {


    public static boolean isNumberInArray(int[] array, int number){
        for(int i:array){
            if(i==number){
                return true;
            }
        }
        return false;
    }

    public static int findMissingNumber(int[] array){
        for(int i=1; i<array.length+1; i++){
            if(!isNumberInArray(array, i)){
                return i;
            }
        }
        throw new RuntimeException("Something went wrong or array doesn't contain missing number");
    }


    public static void main(String[] args) {
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10,2,1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Use some static helper method to find it.
         */
         int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};

        for(int i=1; i<array.length+1; i++){
            if(!isNumberInArray(array,i)){
                System.out.println(i);
            }
        }
        System.out.println(findMissingNumber(array));
    }
}
