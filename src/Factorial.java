public class Factorial {
    public int factorial(int n) {
        return n <= 1 ? n : n * factorial(n-1);
    }
}
