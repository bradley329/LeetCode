package EliminationGame_390;

// The idea is to update and record head in each turn. 
// when the total number becomes 1, head is the only number left.
// I think one of the main points is that the "step" is the difference between two adjacent numbers in the sequence. 
// And the author found that when the head changes, it changes to the very next one on the right.
public class TopSolution {
	public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}
