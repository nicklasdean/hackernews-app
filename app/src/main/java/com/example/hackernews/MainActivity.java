package com.example.hackernews;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hackernews.services.Fetcher;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private final static int TEXT_REQUEST = 1;
    private Fetcher hackerFetch = new Fetcher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView headline = (TextView) findViewById(R.id.article_heading);
        String currentText = headline.getText().toString();
        Log.d(LOG_TAG, currentText);
        headline.setText(currentText +  " AND Something else");
    }

    public void launchAddComment(View view) {
        Intent intent = new Intent(this, AddCommentActivity.class);
        EditText comment = findViewById(R.id.edit_comment);
        String commentAsText = comment.getText().toString();
        intent.putExtra("comment", commentAsText);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                if(data.getBooleanExtra("isConfirmed",false)){
                    Toast.makeText(getApplicationContext(), "Comment is saved", Toast.LENGTH_SHORT).show();
                    EditText viewById = findViewById(R.id.edit_comment);
                    viewById.setText("");
                }
            }
        }
    }
}