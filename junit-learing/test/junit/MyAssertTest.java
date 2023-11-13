package junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {
    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
    @Test
    //  @org.junit.jupiter.api.Test
    void test() {
    boolean test = todos.contains("AWS");
    boolean test2 = todos.contains("GCP");
    assertTrue(test); // These methods only works on boolean
    assertFalse(test2);
    // What's more: assertNull, assertNotNull
    assertArrayEquals(new int[]{1,2}, new int[]{1,2});
    //assertArrayEquals(new int[]{1,2}, new int[]{2,1}); // This one will be error!
    assertEquals(true,test);
    assertEquals(3,todos.size(),"Error Messege");// The third parameter is the error messege
    }

}