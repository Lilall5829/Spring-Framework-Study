package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    private MyMath math = new MyMath();
    @Test
    //  @org.junit.jupiter.api.Test
    void calculateSum_ThreeMemberArray() {
    // Test condition ot asserts
        //  int expectedResult = 5; Test will fail!!!
        assertEquals(6, math.calculateSum(new int[]{1,2,3}));
    }
    @Test
        //  @org.junit.jupiter.api.Test
    void calculateSum_EmptyArray() {
        assertEquals(0, math.calculateSum(new int[]{}));
    }

}