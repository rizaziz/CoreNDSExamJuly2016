package problems;
import java.util.*;
/**
 * Created by mrahman on 4/9/16.
 */
public class Permutation {

    static Set<String> permutations=null;

    public static void findPermutations(String str, int counter, List<String> list){

        List<String> storage=new ArrayList<>();

        String string=str.substring(counter, counter+1);

        if(list.size()==0){
            storage.add(string);
            findPermutations(str, counter, storage);
        }

        for(String s:list){
            for(int j=0; j<s.length()+1; j++){
                storage.add(new StringBuilder(s).insert(j,string).toString());
            }
        }
        counter++;
        if(counter==str.length()){
            permutations=new TreeSet(storage);
            return;
        }
        findPermutations(str, counter, storage);
    }



    public static void printPermutations(){
        int i=0;
        for(String str: permutations){
            System.out.print(str+" ");
            i++;
            if(i%20==0){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        /*
         * Permutation of String "ABC" is "abc" "bac" "bca" "acb" "cab" "cba".
         * Write Java program to compute all Permutation of a String
         *
         */
        List<String> temp=new ArrayList<>();

        findPermutations("abcdef", 0, temp);

        printPermutations();

        System.out.println("Number of Permutations: "+permutations.size());
    }
}
