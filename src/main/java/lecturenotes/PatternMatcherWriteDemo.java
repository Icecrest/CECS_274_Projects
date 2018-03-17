package lecturenotes;
//Created by Sean C. on 2/1/2018

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

public class PatternMatcherWriteDemo {

    public static void main(String[] args) throws FileNotFoundException{
        //GOAL: To write a file based on tollfree.txt that only include company names and numbers

        //STEP 1: Create a File
        File fileIn = new File("C:\\Users\\Sean\\IdeaProjects\\CECS 274 Projects\\src\\main\\java\\lecturenotes\\tollfree.txt");

        Scanner fileReader = new Scanner(fileIn);;
        String currentLine;

        //STEP 2: Create regex, pattern and matcher
        String regex = "([\\w | \\s]+)\\s[.]+\\s([\\d | -]+)";
        Pattern pattern = Pattern.compile(regex);

        Matcher m;

        //STEP 3: Create a PrintWriter object
        PrintWriter fileOut = new PrintWriter("C:\\Users\\Sean\\IdeaProjects\\CECS 274 Projects\\src\\main\\java\\lecturenotes\\tollfree_Updated.txt");


        while(fileReader.hasNextLine()){
            currentLine = fileReader.nextLine();
            m = pattern.matcher(currentLine);
            if(m.find()){
                fileOut.append("Company Name: "+m.group(1)+"\nPh: "+m.group(2)+"\n\n");
            }
        }
        fileReader.close();
        fileOut.close();
    }
}
