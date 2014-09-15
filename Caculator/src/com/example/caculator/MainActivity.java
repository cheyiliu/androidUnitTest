
package com.example.caculator;

import com.test.cpdemo.data.provider.CalContent.history;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected static final String TAG = "MainActivity";
    private EditText mEditTextParam1;
    private EditText mEditTextParam2;
    private TextView mTextViewResult;
    private Button mButtonPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        mEditTextParam1 = (EditText) findViewById(R.id.param1);
        mEditTextParam2 = (EditText) findViewById(R.id.param2);
        mTextViewResult = (TextView) findViewById(R.id.result);
        mButtonPlus = (Button) findViewById(R.id.btn_add);
        mButtonPlus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int param1 = 0;
                int param2 = 0;
                try {
                    param1 = Integer.parseInt(mEditTextParam1.getText().toString());
                    param2 = Integer.parseInt(mEditTextParam2.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i(TAG, "param1=" + param1 + ", param2=" + param2);
                mTextViewResult.setText("" + Caculator.plus(param1, param2));
                // save to cp, just for demo
                ContentValues values = new ContentValues();
                values.put(history.Columns.PARAM1.getName(), param1);
                values.put(history.Columns.PARAM2.getName(), param2);
                values.put(history.Columns.RESULT.getName(), Caculator.plus(param1, param2));
                getContentResolver().insert(history.CONTENT_URI, values);

            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
