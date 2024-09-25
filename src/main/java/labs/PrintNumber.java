package labs;

public class PrintNumber {
    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }

    public static void printNumbers(int n) {
        System.out.print("<<printNumbers(" + n + "): " + (n>0?n:"_"));
        if (n > 0) {
            printNumbers(n-1);
            System.out.print(n + " ");
        }
    }

    private static String getString() {
        return "==>";
    }
}
