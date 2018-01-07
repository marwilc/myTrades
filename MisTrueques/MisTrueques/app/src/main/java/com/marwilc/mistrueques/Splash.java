package com.marwilc.mistrueques;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (TextView)  findViewById(R.id.tvMyTrades);
        imageView = (ImageView) findViewById(R.id.imgvLogoMyTrades);
        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        textView.startAnimation(myAnim);
        imageView.startAnimation(myAnim);

        final Intent intent = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }

        };

        timer.start();
    }
}
