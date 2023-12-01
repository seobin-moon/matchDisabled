package com.example.hackerton;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class mainpage extends AppCompatActivity{
    Button btnSearch;
    Button btnBell;
    Button btnHome;
    Button btnMypage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        btnHome = findViewById(R.id.btnHome);
        btnMypage = findViewById(R.id.btnMypage);

        btnSearch = findViewById(R.id.btnSearch);

        //센터 찾기 버튼 클릭시, 지도 맵 페이지로 이동
        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        });

        btnBell = findViewById(R.id.btnBell);

        //도움벨 버튼 클릭시, 비장애인, 도우미들에게 앱 푸시 알림
        /*btnBell.setOnClickListener(v -> {
            Intent intent = new Intent(this, )
        });*/

        findViewById(R.id.btnBell).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap mLargeIconForNoti =
                        BitmapFactory.decodeResource(getResources(), R.drawable.bell);
                /*PendingIntent mPendingIntent = PendingIntent.getActivity(mainpage.this, 0,
                        new Intent(getApplicationContext(), mainpage.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );*/
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(mLargeIconForNoti);
                imageView.setVisibility(View.VISIBLE);

                Intent intent = new Intent(mainpage.this, mainpage.class);
                PendingIntent mPendingIntent = PendingIntent.getActivity(
                        mainpage.this,0,
                        intent,PendingIntent.FLAG_UPDATE_CURRENT
                );

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(mainpage.this)
                                .setSmallIcon(R.drawable.bell)
                                .setContentTitle("도움벨")
                                .setContentText("누군가 도움을 요청했어요!")
                                .setDefaults(Notification.DEFAULT_SOUND)
                                //.setLargeIcon(mLargeIconForNoti)
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setAutoCancel(true)
                                .setContentIntent(mPendingIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mBuilder.build());
            }
        });
    }
}



