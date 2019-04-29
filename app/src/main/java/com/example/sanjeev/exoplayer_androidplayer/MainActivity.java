package com.example.sanjeev.exoplayer_androidplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sanjeev.exoplayer_androidplayer.ui.AbstractActivity;
import com.example.sanjeev.exoplayer_androidplayer.ui.InfoActivity;

public class MainActivity extends AbstractActivity {

    private EditText contentUrl;
    private String appversion;
    private String libsUsed;
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
        startActivity(intent);
    }

    public void appinfo(View view){
        InfoActivity.showAbout(this);
    }

}
