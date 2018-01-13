package Powerof234;

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
}
