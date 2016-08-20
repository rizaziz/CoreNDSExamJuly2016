package problems;

import java.util.Arrays;

/**
 * Created by mrahman on 4/9/16.
 */
public class Anagram {

    public static boolean isAnagram(String str1, String str2){
        char[] ch1= str1.toCharArray();
        char[] ch2= str2.toCharArray();

        //sorting ch1
        for(int i=0; i<ch1.length-1; i++){
            for(int j=i+1; j<ch1.length; j++){
                if(ch1[i]>ch1[j]){
                    char temp=ch1[i];
                    ch1[i]=ch1[j];
                    ch1[j]=temp;
                }
            }
        }

        //sorting ch2
        for(int i=0; i<ch2.length-1; i++){
            for(int j=i+1; j<ch2.length; j++){
                if(ch2[i]>ch2[j]){
                    char temp=ch2[i];
                    ch2[i]=ch2[j];
                    ch2[j]=temp;
                }
            }
        }
        return Arrays.equals(ch1,ch2);
    }

    public static boolean isAnagram_2(String str1, String str2){

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1, 0, ch1.length);
        Arrays.sort(ch2, 0, ch2.length);

        return Arrays.equals(ch1, ch2);
    }


    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".

        System.out.println(isAnagram("CAT", "ACT"));
        System.out.println(isAnagram("ARMY", "MARY"));
    }
}
