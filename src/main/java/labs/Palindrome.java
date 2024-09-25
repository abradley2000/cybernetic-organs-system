package labs;

public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";
        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        } else {
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                return isPalindrome(str.substring(1, str.length() - 1));
            } else {
                return false;
            }
        }
    }
}
