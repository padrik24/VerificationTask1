package com.nn.podrazhanets.verificationtask1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextForToast;
    private Button mButtonForToast;

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("clickListener", "press button for toast");
            showMessage(mEditTextForToast.getText().toString());
            if(!TextUtils.isEmpty(mEditTextForToast.getText().toString())) {
                startIntent();
            }
        }
    };


    private void startIntent() {
        Intent startSecondActivity = new Intent(this, SecondActivity.class);
        startSecondActivity.putExtra(SecondActivity.MESSAGE, mEditTextForToast.getText().toString());
        startActivity(startSecondActivity);
    }

    private void showMessage(String message) {
        if(!message.isEmpty()) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextForToast = findViewById(R.id.editTextForToast);
        mButtonForToast = findViewById(R.id.buttonForToast);
    }

    @Override
    protected void onResume() {
        Log.d("lifeCycle", "onResume");
        super.onResume();
        mButtonForToast.setOnClickListener(mButtonClickListener);
    }
}
