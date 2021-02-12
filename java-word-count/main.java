import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

class WordCounter {
    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter filename: ");
            String fileName = userInput.nextLine();
            userInput.close();
            System.out.println("There are " + getFileWords(fileName) + " words in " + fileName);
        } else {
            String fileName = args[0];
            System.out.println("There are " + getFileWords(fileName) + " words in " + fileName);
        }
    }

    public static int getFileWords(String fileName) {
        int wordCount = 0;
        try {
            File inputFile = new File(fileName);
            Scanner readFile = new Scanner(inputFile);
            while(readFile.hasNextLine()) {
                String line = readFile.nextLine();
                wordCount += countWords(line);
            }
            readFile.close();
        } catch(FileNotFoundException e) {
            System.out.println("ERROR: File was not found");
            e.printStackTrace();
            System.exit(1);
        }
        return wordCount;
    }

    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
          return 0;
        }
    
        String[] words = input.split("\\s+");
        return words.length;
      }
}