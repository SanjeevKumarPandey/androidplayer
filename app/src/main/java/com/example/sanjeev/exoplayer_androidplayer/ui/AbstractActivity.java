package com.example.sanjeev.exoplayer_androidplayer.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

public class AbstractActivity extends Activity {
    private static final String LOG_TAG = "AbstractActivity";

    protected void trace(String logTag, String msg) {
        Log.d(logTag, msg);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void alertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(LOG_TAG + "#alert", "OK");
            }
        });

        AlertDialog alert = builder.create();
        //alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alert.show();
        alert.getWindow().setLayout(500, 600);
    }
}
