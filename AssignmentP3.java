import java.util.Scanner;
import java.util.Arrays;
public class AssignmentP3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("str1 = ");
        String str1 = sc.nextLine();
        System.out.print("str2 = ");
        String str2 = sc.nextLine();
        System.out.print("str3 = ");
        String str3 = sc.nextLine();
        String clean1 = str1.replaceAll("[^a-zA-Z0-9]", "")
                            .toLowerCase();
        String clean2 = str2.replaceAll("[^a-zA-Z0-9]", "")
                            .toLowerCase();
        String clean3 = str3.replaceAll("[^a-zA-Z0-9]", "")
                            .toLowerCase();
        String reverse = new StringBuilder(clean1)
                .reverse()
                .toString();
        boolean palindrome = clean1.equals(reverse);
        boolean valid = clean1.matches("[a-zA-Z0-9]+");
        char[] a = clean2.toCharArray();
        char[] b = clean3.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        boolean anagram = Arrays.equals(a, b);
        boolean containsPlan = clean1.contains("plan");
        String result1 = String.format(
                "Palindrome Check: %s -> %b",
                str1, palindrome
        );
        String result2 = String.format(
                "Anagram Check: \"%s\" & \"%s\" -> %b",
                str2, str3, anagram
        );
        String result3 = String.format(
                "Contains 'plan': %b",
                containsPlan
        );
        String report = String.join(
                "\n",
                result1,
                result2,
                result3
        );
        System.out.println("\n" + report);
        System.out.println(
                "Regex validation: " + valid
        );
        String x = new String("Java");
        String y = new String("Java");
        String p = x.intern();
        String q = y.intern();
        System.out.println(
                "HashCodes equal: " +
                (p.hashCode() == q.hashCode())
        );
        System.out.println(
                "Interned strings same reference: " +
                (p == q)
        );
        sc.close();
    }
}