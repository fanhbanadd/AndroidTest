package com.example.acer.broadnotifytest_117fd;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by acer on 2017/5/3.
 */

public class MyReceiver extends BroadcastReceiver {
    private Context context;
    private String str="";
    public static NotificationManager manager;
    public static int notifyID=1;


    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        str=intent.getStringExtra("para2");
        Toast.makeText(context,"接收到广播："+str,Toast.LENGTH_SHORT);
        
        sendnotify();
    }

    private void sendnotify() {
        manager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);

        Intent intent=new Intent(context,NotifyActivity.class);
        intent.putExtra("para3",str);
        PendingIntent pintent=PendingIntent.getActivity(
                context,
                notifyID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentTitle("通知的标题")
                .setContentText("通知的内容"+str)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("通知来了")
                .setContentIntent(pintent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis());

        manager.notify(notifyID,builder.build());
    }
}
