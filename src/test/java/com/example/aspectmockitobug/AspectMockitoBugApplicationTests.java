package com.example.aspectmockitobug;

import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AspectMockitoBugApplicationTests {

    ModelClass model;

    @BeforeEach
    public void setup() {
        model=  mock(ModelClass.class);
        model.iterator = mock(Iterator.class);
        doCallRealMethod().when(model).doWork();
    }

    @Test
    void contextLoads() {
        when(model.iterator.hasNext()).thenReturn(true).thenReturn(false);
        when(model.iterator.next()).thenReturn("TEST");

        model.doWork();
    }

}
