package com.marwilc.mistrueques.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.marwilc.mistrueques.R;

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

        /**
         * Inicia la actividad principal
         */
        final Intent intent = new Intent(this, MainActivity.class);

        // crea el hilo para la actividad principal
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
