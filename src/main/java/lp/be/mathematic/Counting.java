package lp.be.mathematic;

public class Counting {

    public long getFactorialResult(int factorial) {
        long result = 1;
        while (factorial > 0) {
            result *= factorial--;
        }
        return result;
    }

}
