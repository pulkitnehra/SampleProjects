package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JSONParser
 */
public class JSONParser {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SimpleJsonValidator <json_file_path>");
            System.exit(1);
        }

        String filePath = args[0];
        String json=null;

        try {
            json = readJsonFromFile(filePath);
            if (json.isEmpty()) {
                System.out.println("Invalid JSON: Empty file");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        if (isValidJson(json)) {
            System.out.println("Valid JSON");
            System.exit(0);
        } else {
            System.out.println("Invalid JSON");
            System.exit(1);
        }
    }
    private static String readJsonFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        return sb.toString();
    }

    private static boolean isValidJson(String json) {
        int index = 0;
        char current;

        // Check for opening curly brace
        if (json.charAt(index) != '{') {
            return false;
        }
        index++;

        // Loop until closing curly brace or error
        while (index < json.length()) {
            current = json.charAt(index);

            // Skip whitespace
            if (Character.isWhitespace(current)) {
                index++;
                continue;
            }

            // Check for closing curly brace
            if (current == '}') {
                return true;
            }

            // Invalid character
            return false;
        }

        // Missing closing curly brace
        return false;
}


}