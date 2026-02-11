import java.util.Scanner;

public class Searchword {
    public static void main(String[] args) {
        System.out.println("Enter your paragraph. Double press Enter when you finish:");
        Scanner scanner = new Scanner(System.in);
        StringBuilder paragraphBuilder = new StringBuilder();
        String previousLine = "";
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty() && previousLine.trim().isEmpty()) {
                break;
            }
            paragraphBuilder.append(line).append("\n");
            previousLine = line;
        }

        String paragraph = paragraphBuilder.toString();

        while (true) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Search and count a single word");
            System.out.println("2. Search for multiple words");
            System.out.println("3. Show which lines multiple words are mentioned");
            System.out.println("4. Exit");
            System.out.print("Choose by entering the number of the service you want: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the word to search: ");
                    String word = scanner.nextLine();
                    new thread1(paragraph, word).start();
                    new thread2(paragraph, word).start();
                }
                case 2 -> {
                    System.out.print("Enter words to search with comma between them: ");
                    String[] words = scanner.nextLine().split(",");
                    for (String w : words) {
                        String word = w.trim();
                        new thread1(paragraph, word).start();
                    }
                }
                case 3 -> {
                    System.out.print("Enter words and separate them with comma: ");
                    String[] words = scanner.nextLine().split(",");
                    for (String w : words) {
                        String word = w.trim();
                        new thread2(paragraph, word).start();
                    }
                }
                case 4 -> {
                    System.out.println("Exiting the code.");
                    return;
                }
                default -> System.out.println("Please choose from the given options.");
            }
        }
    }
}