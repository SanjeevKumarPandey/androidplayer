package com.example.sanjeev.exoplayer_androidplayer.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.system.Os;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import com.example.sanjeev.exoplayer_androidplayer.R;
import com.example.sanjeev.exoplayer_androidplayer.logging.InMemoryLogger;
import com.example.sanjeev.exoplayer_androidplayer.logging.Logger;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

import static com.google.android.exoplayer2.util.Util.SDK_INT;


public class InfoActivity {

    private static final String LOG_TAG = "[UmbrellaPlayer InfoActivity]";
    public static Logger logger = new InMemoryLogger();
    private static String ExoPlayerVersion = ExoPlayerLibraryInfo.VERSION;
    private static int BuildOS = Build.VERSION.SDK_INT;
    private static String DeviceModel = Build.MODEL;
    private static String DeviceBrand= Build.BRAND;
    private static String DeviceProduct= Build.PRODUCT;
    private static String DeviceSoftware= System.getProperty("os.version");
    private static String DeviceFingerprint=Build.FINGERPRINT;
    private static String DeviceProcessor=Build.MANUFACTURER;
    private static String DeviceResolution = "unknown";

    public static void showAbout(Activity parent) {
        InfoActivity.logger
                .i(LOG_TAG + "#showAbout", "Displaying about information.");

        final AlertDialog.Builder ab = new AlertDialog.Builder(parent);
        ab.setTitle(R.string.About);
        View view = parent.getLayoutInflater().inflate(R.layout.about, null);

        // Umbrella Player version
        TextView tv = (TextView) view.findViewById(R.id.aboutUmbrellaPlayerVersion);
        tv.setText(parent.getString(R.string.aboutUmbrellaPlayerVersion)+ " Dev 0.1");

        // Umbrella Player description
        tv = (TextView) view.findViewById(R.id.aboutAppDescription);
        tv.setText(parent.getString(R.string.aboutApp_Description) + " Android HLS Player");

        // Developer Info
        tv = (TextView) view.findViewById(R.id.aboutDeveloper);
        tv.setText("Developed By: "+parent.getString(R.string.author));

        // ExoPlayer version
        tv = (TextView) view.findViewById(R.id.aboutExoPlayer);
        tv.setText(parent.getString(R.string.aboutExoPlayerDescription) + " " + ExoPlayerVersion);

        // Show device information
        tv = (TextView) view.findViewById(R.id.aboutDeviceModel);
        tv.setText(parent.getString(R.string.aboutDeviceModel) + " " + DeviceModel);

        tv = (TextView) view.findViewById(R.id.aboutDeviceBrand);
        tv.setText(parent.getString(R.string.aboutDeviceBrand) + " " + DeviceBrand);

        tv = (TextView) view.findViewById(R.id.aboutDeviceSoftware);
        tv.setText(parent.getString(R.string.aboutDeviceSoftware) + " "
                +  "ExoPlayer SDK: " + SDK_INT + ", Device OS Build: " + "BHA");

        tv = (TextView) view.findViewById(R.id.aboutDeviceProduct);
        tv.setText(parent.getString(R.string.aboutDeviceProduct) + " " + DeviceProduct);

        //InfoActivity.logger.i(LOG_TAG + "#DeviceInfo", Build.getRadioVersion()+ Build.PRODUCT + Build.FINGERPRINT + Build.MANUFACTURER + Build.ID);

        tv = (TextView) view.findViewById(R.id.aboutDeviceFingerprint);
        tv.setText(parent.getString(R.string.aboutDeviceFingerprint) + " " + DeviceFingerprint);

        tv = (TextView) view.findViewById(R.id.aboutDeviceProcessor);
        tv.setText(parent.getString(R.string.aboutDeviceProcessor) + " " + System.getProperty("os.arch", "Unknown"));

        tv = (TextView) view.findViewById(R.id.aboutDeviceResolution);
        String orientation = parent.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? "landscape"
                : "portrait";
        tv.setText(orientation);

        ab.setView(view);
        ab.setNegativeButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Just close the dialog.
                    }
                });
        ab.show();

    }
}