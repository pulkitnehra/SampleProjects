//type man wc in terminal for more info


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WccTool{
    public static void main(String args[]){
        System.out.println("Hello, World!");
        readFile();
    }
    
    public static void readFile(){
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
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

