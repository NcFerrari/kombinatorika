package lp.be.mathematic;

public class Combinatorics {

    private final Counting counting = new Counting();

    /**
     * V(k,n) = n! / (n-k)!
     * <p>
     * we are not counting with factorial. We just need numbers before shortening factorial
     *
     * @param k class
     * @param n elements
     */
    public long variation(int k, int n) {
        if (n < k) {
            return 0;
        }
        long result = 1;
        int numerator = n;
        int denominator = n - k;
        while (numerator > denominator) {
            result *= numerator--;
        }
        return result;
    }

    public void permutation(int n) {

    }

    public void combination(int k, int n) {

    }
}
