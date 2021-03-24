package com.example.example3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context myContext;
    Toast myToast;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = getApplicationContext();
        myToast = new Toast(myContext);
        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);
        dialogConf.setTitle("Choose a pill");
        dialogConf.setMessage("Choose wisely");
        dialogConf.setIcon(R.mipmap.ic_launcher);


        dialogConf.setNeutralButton("Red Pill", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myToast.makeText(myContext, "Wake Up", Toast.LENGTH_LONG).show();
            }
        });

        dialogConf.setPositiveButton("Blue Pill", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myToast.makeText(myContext, "Continue in simulation", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog myDialog = dialogConf.create();
        myDialog.show();


        Notification.Builder notifConf = new Notification.Builder(MainActivity.this);
        notifConf.setContentTitle("Be sure to boing or bong")
                .setContentText("Its important to do this!")
                .setSmallIcon(R.mipmap.ic_launcher);

        Intent myIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(myContext, 0, myIntent, 0);
        notifConf.setContentIntent(contentIntent);

        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(2, notifConf.build());
    }
}