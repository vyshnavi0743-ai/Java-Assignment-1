import java.util.Scanner;
public class AssignmentP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();
        String[] words = s.split(" ");
        System.out.println("Word Count: " + words.length);
        int firstSpace = s.indexOf(" ");
        String firstWord = s.substring(0, firstSpace);
        int lastSpace = s.lastIndexOf(" ");
        String lastWord = s.substring(lastSpace + 1);
        System.out.println("First Word: " + firstWord);
        System.out.println("Last Word: " + lastWord);
        System.out.println("First 'J' index: " + s.indexOf('J'));
        System.out.println("Last 'J' index: " + s.lastIndexOf('J'));
        System.out.println("Comparison: " + firstWord.compareTo(lastWord));
        char[] ch = s.toCharArray();
        sc.close();  
    }
}