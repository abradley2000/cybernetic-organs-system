package labs;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello, world!";
        String reversed = reverse(str);
        System.out.println("Reversed string: " + reversed);
    }

    private static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
