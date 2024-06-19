import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the text
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        // Count word frequencies
        Map<String, Integer> wordFrequencies = countWordFrequencies(text);

        // Display the word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    public static Map<String, Integer> countWordFrequencies(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Split the text into words
        String[] words = text.split("\\s+");

        // Count the frequency of each word
        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase to ensure case-insensitivity
            word = word.replaceAll("[^a-zA-Z]", ""); // Remove any punctuation marks

            if (word.isEmpty()) {
                continue;
            }

            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }
}