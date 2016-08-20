package math;

import java.math.BigInteger;

/**
 * Created by mrahman on 4/9/16.
 */
public class Factorial {

    public static int result=1;
    public static BigInteger total=BigInteger.ONE;

    public static Number getFactorialWithIteration(int number){
        BigInteger result=BigInteger.ONE;
        for(int i=1; i<=number; i++){
            result=result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger getFactorialWithRecursion(int number){
        if(number==0){
            return total;
        }else{
            return total.multiply(BigInteger.valueOf(number)).multiply(getFactorialWithRecursion(number-1));
        }
    }

    public static int getFactorialWithIteration_V2(int number){
        int result=1;
        for(int i=1; i<=number; i++){
            result*=i;
        }
        return result;
    }

    public static int getFactorialWithRecursion_V2(int number){
        if(number==0){
            return result;
        }else{
            return result*number*getFactorialWithRecursion_V2(number-1);
        }
    }

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */
        System.out.println(getFactorialWithIteration_V2(5));
        System.out.println(getFactorialWithRecursion_V2(5));
        System.out.println(getFactorialWithIteration(100));
        System.out.println(getFactorialWithRecursion(100));
    }
}
