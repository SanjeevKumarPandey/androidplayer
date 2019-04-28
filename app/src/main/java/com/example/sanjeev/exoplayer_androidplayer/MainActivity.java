package com.example.sanjeev.exoplayer_androidplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sanjeev.exoplayer_androidplayer.ui.AbstractActivity;

public class MainActivity extends AbstractActivity {

    private EditText contentUrl;
    public static final String EXTRA_MESSAGE = "com.example.sanjeev.exoplayer_androidplayer.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlayback(View view){
        Intent intent = new Intent(this, VideoPlayerActivity.class);

        contentUrl = (EditText) findViewById(R.id.contentUrlText);

        String mediaContentUrl = contentUrl.getText().toString();
        if(mediaContentUrl.isEmpty()){
            contentUrl.setText(getString(R.string.contentUrl));
        } else {
            contentUrl.setText(mediaContentUrl);
        }
        intent.putExtra(EXTRA_MESSAGE, contentUrl.getText().toString());
        //alertDialog("media", contentUrl.getText().toString());
        startActivity(intent);
    }

}
