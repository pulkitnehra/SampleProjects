import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//app to model the wc unix terminal command

public class WccTool {
    public static void main(String args[]) {
        String filepath = "/home/zemanparis/Downloads/Projects/SampleProjects/test.txt";
        if (args.length==0){
            System.out.print(countLines(filepath) + " ");
            System.out.print(countWords(filepath) + " ");
            System.out.print(printFileSize(filepath) + " ");
            System.out.print(filepath.substring(filepath.indexOf('.')-4)+" ");
            System.out.println();
        }
        // Reading the parameters from command line
        else{
        String parametersPassed = args[0];
        switch (parametersPassed) {
            case "-c":
            System.out.println(printFileSize(filepath));
                break;
            case "-l":
            System.out.println(countLines(filepath));
                break;
            case "-w":
            System.out.println(countWords(filepath));
                break;
            case "-m":
            System.out.println(countCharacters(filepath));
                break;
            default:
            System.out.println(parametersPassed);
            break;
        }
        }
    }

    public static long printFileSize(String file) {
        File fileName = new File(file);
        return fileName.length();
        
    }

    public static long countLines(String file) {
        long countlines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                countlines += 1;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countlines;
    }

    public static long countWords(String file) {
        int countWords = 0;
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = Pattern.compile("\\s+").split(line);
                for (String w : parts) {
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

    public static long countCharacters(String file) {
        long countChars = 0;
        try {
            String data;
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream, "UTF-8");
            BufferedReader reader = new BufferedReader(input);
            while ((data = reader.readLine()) != null) {
                countChars += data.length() + 1;
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countChars;
    }

}
