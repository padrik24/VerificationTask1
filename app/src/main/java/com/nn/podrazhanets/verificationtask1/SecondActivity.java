package com.nn.podrazhanets.verificationtask1;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String MESSAGE = "MESSAGE";

    private TextView mTextViewForMessage;
    private Button mButtonPress;

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startBrowserIntent();
        }
    };

    private void startBrowserIntent() {
        Intent browserIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        browserIntent.putExtra(SearchManager.QUERY, mTextViewForMessage.getText().toString());
        startActivity(browserIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextViewForMessage = findViewById(R.id.textViewForMessage);
        mButtonPress = findViewById(R.id.buttonPress);

        Bundle bundle = getIntent().getExtras();

        String text = bundle != null ? bundle.getString(MESSAGE) : "";
        mTextViewForMessage.setText(text);
    }

    @Override
    protected void onResume(){
        super.onResume();

        mButtonPress.setOnClickListener(mButtonClickListener);
    }
}
