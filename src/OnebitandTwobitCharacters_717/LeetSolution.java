package OnebitandTwobitCharacters_717;

// it's not very straight forward since according to the description
// there are multiple ways to decode the string and how do we DARE to return the result
// when only one decoding routine is not guaranteed!?
public class LeetSolution {
	public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) i++;
            else i += 2;
        }
        return i == n - 1;
    }
}
