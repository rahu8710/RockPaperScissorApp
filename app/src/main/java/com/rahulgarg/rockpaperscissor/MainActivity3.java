package com.rahulgarg.rockpaperscissor;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity3 extends AppCompatActivity {
    TextView highScore , comsc , yosc,totalWin,totalLose;
    String editVal;
    MediaPlayer player;
    ImageView imageView;
    int tWin=0, tLose= 0;
    @Override
    protected void onResume() {
        super.onResume();
        player.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        highScore = findViewById(R.id.highScore);
        yosc = findViewById(R.id.yosc);
        totalWin = findViewById(R.id.totalWin);
        totalLose = findViewById(R.id.totalLose);
        imageView  = findViewById(R.id.imageView);
        comsc = findViewById(R.id.comsc);
        player = MediaPlayer.create(this, R.raw.riseandshine);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();

        Intent intent = getIntent();
        int message = Integer.parseInt(intent.getStringExtra("key"));
        int message1 = Integer.parseInt(intent.getStringExtra("key1"));
        yosc.setText(""+message);
        comsc.setText(""+message1);
        SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
        int editVal = Integer.parseInt(sP.getString("name","0"));
        tWin = Integer.parseInt(sP.getString("totalWin","0"));
        tLose = Integer.parseInt(sP.getString("totalLose","0"));
         if(message>message1)
        {
            imageView.setImageResource(R.drawable.win);
            tWin++;
            SharedPreferences.Editor ed = sP.edit();
            ed.putString("totalWin", ""+tWin);
            ed.apply();
        }
        else{
            if(message<message1) {
                imageView.setImageResource(R.drawable.lose);
                tLose++;
                SharedPreferences.Editor ed = sP.edit();
                ed.putString("totalLose", ""+tLose);
                ed.apply();
            }
            else
                imageView.setImageResource(R.drawable.draw);
        }
        if(message>message1  &&  message>editVal) {
            SharedPreferences.Editor ed = sP.edit();
            ed.putString("name", ""+message);
            ed.apply();
        }
        int editVal1 = Integer.parseInt(sP.getString("name","0"));
        highScore.setText("High Score = "+editVal1);
        int totalWin1 = Integer.parseInt(sP.getString("totalWin","0"));
        totalWin.setText("Total Wins = "+totalWin1);
        int totalWin2 = Integer.parseInt(sP.getString("totalLose","0"));
        totalLose.setText("Total Loses = "+totalWin2);
    }
    public void openActivity2(View v)
    {
        Intent intent2= new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
}