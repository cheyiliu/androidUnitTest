
package com.example.caculator.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.caculator.MainActivity;
import com.example.caculator.R;

public class TestActivityFunc extends ActivityInstrumentationTestCase2<MainActivity> {

    // or extends this SingleLaunchActivityTestCase
    // public class TestActivityFunc extends
    // SingleLaunchActivityTestCase<MainActivity> {
    // public TestActivityFunc() {
    // super("com.example.caculator", MainActivity.class);
    // }

    public TestActivityFunc() {
        super(MainActivity.class);
    }

    private EditText mEditTextParam1;
    private EditText mEditTextParam2;
    private TextView mTextViewResult;
    private Button mButtonPlus;
    private Activity mActivity;

    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mEditTextParam1 = (EditText) mActivity.findViewById(R.id.param1);
        mEditTextParam2 = (EditText) mActivity.findViewById(R.id.param2);
        mTextViewResult = (TextView) mActivity.findViewById(R.id.result);
        mButtonPlus = (Button) mActivity.findViewById(R.id.btn_add);
    }

    protected void tearDown() throws Exception {
        // mActivity.finish(); will be finished by supper
        super.tearDown();
    }

    public void testPreconditions() {
        assertNotNull(mEditTextParam1);
        assertNotNull(mEditTextParam2);
        assertNotNull(mTextViewResult);
        assertNotNull(mButtonPlus);
        assertNotNull(mActivity);
    }

    // view only could be changed on main thread
    @UiThreadTest
    public void testLegalInput() {
        mEditTextParam1.setText("1");
        mEditTextParam2.setText("2");
        mButtonPlus.performClick();

        assertEquals("3", mTextViewResult.getText().toString());
    }

    @UiThreadTest
    public void testIllegalInput() {
        mEditTextParam1.setText("a");
        mEditTextParam2.setText("b");
        mButtonPlus.performClick();

        assertEquals("0", mTextViewResult.getText().toString());
    }
}
