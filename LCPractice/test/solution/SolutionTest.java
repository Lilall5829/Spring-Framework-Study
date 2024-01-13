package solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    void test(){
        int[] prices = {7,6,4,3,1};
        assertEquals(0, solution.maxProfit(prices));
    }
}