package solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    void test(){
        assertEquals(false, solution.isAnagram("cat","rat"));
        assertEquals(true, solution.isAnagram("anagram","nagaram"));
    }
}