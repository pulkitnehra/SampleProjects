import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//app to model the wc unix terminal command

public class WccTool {
    public static void main(String args[]) {
        // Reading the parameters from command line
        if (args.length == 0) {
            // No arguments provided, read from standard input
            handleStandardInput("-all", false);
        } else {
            String option = null;
            String filepath = null;
            // Parse the arguments to find the option and filepath
            for (int i = 0; i < args.length; i++) {
                if (args[i].startsWith("-")) {
                    option = args[i];
                } else {
                    filepath = args[i];
                }
            }

            // Validate and handle based on the found option and filepath
            if (option != null && filepath != null) {
                // Option and filename provided
                handleOption(option, filepath, true);
            } else if (option != null) {
                // Only an option provided, read from standard input
                handleStandardInput(option, false);
            } else if (filepath != null) {
                // Only a filename provided, execute all methods by default
                printAllMethods(filepath, true);
            } else {
                System.out.println("Invalid arguments provided. Usage: java WccTool <option> <filename>");
            }
        }
    }

    public static void handleStandardInput(String input, boolean printFileName) {
        // Check if input is a valid option or a filename
        if (input.startsWith("-")) {
            // Handle reading from standard input with the specified option
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                // Create a temporary file to process the content
                File tempFile = File.createTempFile("tempfile", ".txt");
                tempFile.deleteOnExit();

                try (PrintWriter writer = new PrintWriter(tempFile)) {
                    writer.write(content.toString());
                }

                // Perform action based on option
                handleOption(input, tempFile.getAbsolutePath(), printFileName);

            } catch (IOException e) {
                System.out.println("Error reading from standard input: " + e.getMessage());
            }
        }
    }

    public static void handleOption(String option, String filepath, boolean printFileName) {
        switch (option) {
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
            case "-all":
                printAllMethods(filepath, printFileName);
                break;
            default:
                System.out.println("Unsupported option for standard input: " + option);
                break;
        }
    }

    // Check if the filename has an extension
    public static boolean hasValidFileExtension(String filename) {
        if (filename.lastIndexOf(".") != -1 && filename.lastIndexOf(".") != 0) {
            String extension = filename.substring(filename.lastIndexOf(".") + 1);
            return extension.matches("txt|csv"); // Add more extensions as needed
        }
        return false;
    }

    public static void printAllMethods(String filepath, boolean printFileName) {
        System.out.print(countLines(filepath) + " ");
        System.out.print(countWords(filepath) + " ");
        System.out.print(printFileSize(filepath) + " ");
        if (printFileName) {
            System.out.print(filepath);
        }
        System.out.println();
    }

    public static long printFileSize(String file) {
        File fileName = new File(file);
        if (!fileName.exists()) {
            System.out.println("File " + file + "does not exist.");
            return -1;
        }
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
            System.out.println("Error reading file: " + e.getMessage());
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
            System.out.println("Error reading file: " + e.getMessage());
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
            System.out.println("Error reading file: " + e.getMessage());
        }
        return countChars;
    }

}
