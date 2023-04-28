package search;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] corpus = scanner.nextLine().trim().split("\\s");
        String word = scanner.nextLine();

        for (int i = 0; i < corpus.length; i++) {
            if (corpus[i].equals(word)) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println("Not found");
    }
}
