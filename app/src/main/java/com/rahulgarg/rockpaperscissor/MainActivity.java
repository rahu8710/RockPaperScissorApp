package com.rahulgarg.rockpaperscissor;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    int i=0, count =0 , count1=0;
    ImageView rock , paper , scissor, you , computer ;
    TextView setter, youScore, computerScore;
    MediaPlayer player1;
    public void playerTap (View view)
    {
        Intent intent1 = new Intent(this, MainActivity3.class);
        ImageView img=(ImageView)view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        player1.start();
        if (i < 10) {
            if(tappedImage==0)
                you.setImageResource(R.drawable.rock);
            else{
                if(tappedImage==1)
                    you.setImageResource(R.drawable.paper);
                else
                    you.setImageResource(R.drawable.scissor);
            }
            computer.setTranslationY(-1000f);
            Random random = new Random();
            int rand = random.nextInt(3);
            if (rand == 0)
                computer.setImageResource(R.drawable.rock);
            else {
                if (rand == 1)
                    computer.setImageResource(R.drawable.paper);
                else
                    computer.setImageResource(R.drawable.scissor);
            }
            computer.animate().translationYBy(1000f).setDuration(300);
            if (rand == Integer.parseInt(img.getTag().toString()))
                setter.setText("Draw");
            else if ((rand == 0 && Integer.parseInt(img.getTag().toString()) == 1) || (rand == 1 && Integer.parseInt(img.getTag().toString()) == 2) || (rand == 2 && Integer.parseInt(img.getTag().toString()) == 0)) {
                setter.setText("You Win");
                count++;
                youScore.setText("" + count);
            } else {
                setter.setText("You Lose");
                count1++;
                computerScore.setText("" + count1);
            }
            i++;
        } else {
            intent1.putExtra("key", "" + count);
            intent1.putExtra("key1", "" + count1);
            startActivity(intent1);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        player1 = MediaPlayer.create(this, R.raw.tapsound);
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        youScore = findViewById(R.id.youScore);
        computerScore = findViewById(R.id.computerScore);
        you = findViewById(R.id.you);
        setter = findViewById(R.id.setter);
        computer = findViewById(R.id.computer);
        scissor = findViewById(R.id.scissor);
    }
}
