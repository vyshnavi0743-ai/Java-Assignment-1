import java.util.Scanner;
public class AssignmentP4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Full name = ");
        String fullName = scanner.nextLine();
        System.out.print("Email = ");
        String email = scanner.nextLine();
        System.out.print("Sentence = ");
        String sentence = scanner.nextLine();
        System.out.println("\n OUTPUT ");
        String formattedName = "";
        if (!fullName.isBlank()) { 
            String[] words = fullName.split(" "); 
            for (String word : words) {
                if (!word.isEmpty()) {      
                    formattedName += word.substring(0, 1).toUpperCase() 
                                  + word.substring(1).toLowerCase() + " ";
                }
            }
            formattedName = formattedName.trim();
        }
        System.out.println("Formatted Name: " + formattedName);
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        boolean isValidEmail = email.matches(emailRegex); 
        System.out.println("Valid Email: " + isValidEmail);
        String maskedEmail = "";
        if (isValidEmail) {
            int atIndex = email.indexOf("@"); 
            String localPart = email.substring(0, atIndex); 
            String domainPart = email.substring(atIndex);
            if (localPart.length() > 3) {    
                String visible = localPart.substring(0, 3);
                int maskLength = localPart.length() - 3;
                maskedEmail = visible + "*".repeat(maskLength) + domainPart; 
            } else {
                maskedEmail = localPart + domainPart;
            }
        } else {
            maskedEmail = "Invalid Email Format (Cannot Mask)";
        }
        System.out.println("Masked Email: " + maskedEmail);
        String reversedSentence = "";
        String[] sentenceWords = sentence.split(" "); 
        for (String word : sentenceWords) {
            char[] chars = word.toCharArray(); 
            String reversedWord = "";
            for (int i = chars.length - 1; i >= 0; i--) {
                reversedWord += chars[i];
            }
            reversedSentence += reversedWord + " ";
        }
        System.out.println("Reversed Words: " + reversedSentence.trim());
        int vowelCount = 0;
        String lowerSentence = sentence.toLowerCase(); 
        for (int i = 0; i < lowerSentence.length(); i++) {
            char ch = lowerSentence.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        System.out.println("Vowel Count: " + vowelCount);
        scanner.close();
    }
}