
package com.example.caculator.test;

import android.content.Intent;
import android.test.ServiceTestCase;

import com.example.caculator.MyService;

public class TestServiceFunc extends ServiceTestCase<MyService> {

    MyService myService;

    public TestServiceFunc() {
        super(MyService.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        setupService();
        myService = getService();
        assertNotNull(myService);

    }

    public void testStartService() {
        startService(new Intent("com.test.service.unittest"));
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    //TODO some other case
}
