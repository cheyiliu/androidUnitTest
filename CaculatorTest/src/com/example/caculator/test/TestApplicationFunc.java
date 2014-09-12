
package com.example.caculator.test;

import android.test.ApplicationTestCase;

import com.example.caculator.MyApplication;

public class TestApplicationFunc extends ApplicationTestCase<MyApplication> {

    MyApplication myApplication;

    public TestApplicationFunc() {
        super(MyApplication.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        createApplication();// need to create firstly
        myApplication = getApplication();
        assertNotNull(myApplication);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMyappFunc() {
        assertEquals(12345, myApplication.getConstant12345());
    }
}
