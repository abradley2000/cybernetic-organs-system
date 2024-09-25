package labs;

public class SimpleRecursion {

    public static void main(String[] args) {
        System.out.println(mystery(20));
    }

    public static int mystery(int n) {
        if (n == 0) {
            return 0;
        }
        return mystery(n / 2) + n;
    }

    /**
     * Step-by-Step Breakdown of mystery(20)
     * mystery(20):
     *
     * n = 20 → mystery(20 / 2) + 20 = mystery(10) + 20
     * mystery(10):
     *
     * n = 10 → mystery(10 / 2) + 10 = mystery(5) + 10
     * mystery(5):
     *
     * n = 5 → mystery(5 / 2) + 5 = mystery(2) + 5
     * mystery(2):
     *
     * n = 2 → mystery(2 / 2) + 2 = mystery(1) + 2
     * mystery(1):
     *
     * n = 1 → mystery(1 / 2) + 1 = mystery(0) + 1
     * mystery(0):
     *
     * Base case returns 0.
     *
     * mystery(0) = 0
     * mystery(1) = mystery(0) + 1 = 0 + 1 = 1
     * mystery(2) = mystery(1) + 2 = 1 + 2 = 3
     * mystery(5) = mystery(2) + 5 = 3 + 5 = 8
     * mystery(10) = mystery(5) + 10 = 8 + 10 = 18
     * mystery(20) = mystery(10) + 20 = 18 + 20 = 38
     */

}
