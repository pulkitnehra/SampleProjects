//type man wc in terminal for more info

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WccTool{
    public static void main(String args[]){
        String file = "/home/zemanparis/Downloads/Projects/SampleProjects/test.txt";
        // printFileSize();
        // System.out.println(countLines(file));
        System.out.println(countWords(file)); //59931
        // System.out.println(countCharacters(file));
    }
    
    public static void printFileSize(){
        try {
            File file = new File("/home/zemanparis/Downloads/Projects/SampleProjects/test.txt");
            Scanner readFileContent = new Scanner(file);
            System.out.println("Printing data...");
            String data = "";
            while (readFileContent.hasNextLine()) {
                data = readFileContent.nextLine();
                // System.out.println(data.length());
            }
            System.out.println("The bytes in the file is:"+file.length());
            readFileContent.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static long countLines(String file){
        long countlines = 0;
        try {
            System.out.println("Counting lines...");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine()!=null) {
                countlines +=1;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countlines;
    }
    public static long countWords(String file){
        int countWords = 0;    
       int count = 0;
       try {
        BufferedReader br = new BufferedReader (new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
              String[] parts = Pattern.compile("\\s+").split(line);
              for( String w : parts)
              {
                count++;        
              }
           }
           countWords = count;
           br.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }         
        return countWords;
    }
    
    public static long countCharacters(String file){
        long countChars = 0;
        try {
            System.out.println("Counting characters...");
            String data;
            // Locale locale = Locale.getDefault();
            // String language = locale.getLanguage();
            // String country_uni = locale.getISO3Country();
            
            // Locale.getDefault();
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream,"UTF-8");
            BufferedReader reader = new BufferedReader(input);
            while ((data = reader.readLine())!=null) {
                countChars += data.length()+1;
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countChars;
    }



}

