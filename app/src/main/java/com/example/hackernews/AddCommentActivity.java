package com.example.hackernews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddCommentActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private boolean isCommentConfirmed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent intentFromMainActivity = getIntent();
        String extraComment = intentFromMainActivity.getStringExtra("comment");
        TextView commentFromMain = (TextView) findViewById(R.id.commentFromMain);
        commentFromMain.setText(extraComment);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void confirmComment(View view) {
        isCommentConfirmed = true;
        Intent replyIntent = new Intent();
        replyIntent.putExtra("isConfirmed",isCommentConfirmed);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}