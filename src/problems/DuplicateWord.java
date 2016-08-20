package problems;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by mrahman on 4/9/16.
 */
public class DuplicateWord {

    public static Map<String, Integer> getDuplicates(String str){

        Map<String,Integer> duplicates=new HashMap<>();

        Scanner sc=new Scanner(str);
        sc.useDelimiter(Pattern.compile("\\.*\\s"));

        String s=null;

        Set<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();

        while(sc.hasNext()){
            s=sc.next();
            set.add(s);
            list.add(s);
        }

        for(String str1:set){
            int counter=0;
            for(String str2:list){
                if(str1.equals(str2)){
                    counter++;
                }
            }
            if(counter!=1){
                duplicates.put(str1, counter);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        System.out.println(getDuplicates(st));

    }

}
