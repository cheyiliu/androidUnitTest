
package com.example.caculator.test;

import com.example.caculator.Caculator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestCaculatorFunc extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAdd() {
        Assert.assertEquals(3, Caculator.plus(1, 2));
    }

    public void testMinus() {
        Assert.assertEquals(3, Caculator.plus(5, -2));
    }
}
