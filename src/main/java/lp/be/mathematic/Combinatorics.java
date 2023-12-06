package lp.be.mathematic;

import lp.be.service.LoggerService;
import lp.be.serviceimpl.LoggerServiceImpl;
import org.apache.log4j.Logger;

public class Combinatorics {

    private final LoggerService loggerService = LoggerServiceImpl.getInstance(Combinatorics.class);
    private final Logger log = loggerService.getLog();

    /**
     * V(k,n) = n! / (n-k)!
     * <p>
     * we are not counting with factorial. We just need numbers before shortening factorial
     *
     * @param k class
     * @param n elements
     * @return sum of variation
     */
    public long variation(int k, int n) {
        if (n < k || n < 1 || k < 1) {
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

    /**
     * P(n) = n!
     *
     * @param n - elements
     * @return sum of factorial
     */
    public long permutation(int n) {
        return variation(n, n);
    }

    public void combination(int k, int n) {
        // TODO document why this method is empty
    }

    /**
     * get n!
     *
     * @param element number of factorial without !
     * @return sum of factorial
     */
    public long factorial(int element) {
        long result = 1;
        while (element > 0) {
            result *= element--;
        }
        return result;
    }

    public void count() {
        log.info(2 * permutation(5) - variation(2, 6));
        log.info(variation(4, 4) - permutation(4) + variation(2, 3));
        log.info(6 * variation(2, 10) - permutation(4));
        log.info(2 * permutation(3) - 3 * variation(3, 4) - permutation(2));
    }
}
