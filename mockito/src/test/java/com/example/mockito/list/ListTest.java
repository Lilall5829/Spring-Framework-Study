package com.example.mockito.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void test() {
        List listMock = mock(List.class);
//        listmock.size()=>3
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
    }

    @Test
    void multipleTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);// The first calling will return 1 and the second calling will return 2. And the last return value will be default!
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    void specificParameters() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("SomeString");
        assertEquals("SomeString", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    void genericParameters() {
        List listMock = mock(List.class);
// This line uses a generic Mockito matcher (Mockito.anyInt()) to stub the behavior of the get method. It says that regardless of the integer argument passed to the get method, it should always return the string "SomeOtherString".
        when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
        assertEquals("SomeOtherString", listMock.get(0));
        assertEquals("SomeOtherString", listMock.get(1));
    }
}
