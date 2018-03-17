package lecturenotes;
//Created by Sean C. on 2/1/2018

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherDemo {

    public static void main(String [] args){
        // GOAL: To match one string to the regex we created

        //STEP 1: Create the regex (test it before using it at regex101.com
        String regex = "([\\w | \\s]+)\\s[.]+\\s([\\d | -]+)";
        //STEP 2: Create a pattern by using the regex
        Pattern pattern = Pattern.compile(regex);
        //STEP 3: Create the string you wish to match the pattern with
        String str = "Abacus Associates  ....................... 1-800-547-5995";
        //STEP 4: Create a matcher object to match the pattern to your string
        Matcher m = pattern.matcher(str);

        if(m.find()){ // If the matcher finds groups that match the given regex
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

    }

}
