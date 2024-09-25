package labs;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        int ifactorial = iterativeFactorial(number);
        System.out.println("Interative: Factorial of " + number + " is " + ifactorial);
        int fac = factorial(number);
        System.out.println("Recursive: Factorial of " + number + " is " + fac);
    }

    private static int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    private static int iterativeFactorial(int number) {
        if (number==0){
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *=i;
        }
        return result;
    }
}
