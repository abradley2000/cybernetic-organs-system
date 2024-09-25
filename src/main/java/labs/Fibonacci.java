package labs;

public class Fibonacci {
    public static void main(String[] args) {
        int number = 10;
        int fib = fibonacci(number);
        System.out.println("Fibonacci of " + number + " is " + fib);
    }

    private static int fibonacci(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
