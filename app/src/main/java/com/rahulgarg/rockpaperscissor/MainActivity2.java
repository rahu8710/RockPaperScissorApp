package com.rahulgarg.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class MainActivity2 extends AppCompatActivity {
    MediaPlayer player;

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
        setContentView(R.layout.activity_main2);
        player = MediaPlayer.create(this, R.raw.riseandshine);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();
    }
        public void openActivity(View v)
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
}