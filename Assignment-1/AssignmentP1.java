import java.util.Scanner;
public class AssignmentP1 {
    public static String processText(String input) {
        String str = input.trim();
        if (str.isEmpty()) {
            return "EMPTY_STRING";
        }
        if (str.equalsIgnoreCase("admin")) {
            return "RESERVED_WORD";
        }
        str = str.replace("_", " ");

        if (str.toLowerCase().startsWith("temp")
                && str.toLowerCase().endsWith("user")) {
            str = str.concat("_FLAGGED");
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String result = processText(input);
        System.out.println("Output: " + result);
        sc.close();
    }
}