package algorithm;

import java.util.Arrays;

/**
 * Created by Aziz on 8/19/2016.
 */
public class MergeSort {

    public static int[] array1=new int[]{1,3,5};
    public static int[] array2=new int[]{2,4,6};
    public static int[] array3=new int[6];

    public static void merge(){
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array2.length; j++){
                if(array1[i]>array2[j]){
                    array2[i+j]=array2[j];
                }
            }
        }
    }

    public static void main(String[] args){
        merge(0,3,5);
        System.out.println(Arrays.toString(array));
    }
}
