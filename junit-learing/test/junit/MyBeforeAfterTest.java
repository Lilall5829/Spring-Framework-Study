package junit;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {
    // Cause JUnit has no guarantee of the execution sequence of test, sometimes we need to make order explicitly

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll");
    }
    @BeforeEach // Execute this method before each test
    void beforeEach(){
        System.out.println("BeforeEach");
    }
    @AfterEach // Execute this method after each test
    void afterEach(){
        System.out.println("AfterEach");
    }
    @Test
    void test1(){
        System.out.println("test1");
    }
    @Test
    void test2(){
        System.out.println("test2");
    }
    @Test
    void test3(){
        System.out.println("test3");
    }
}
