package com.example.heizepalvin.nikeplus;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by soyounguensoo on 2017-09-13.
 */

public class MarathonPlayActivity extends AppCompatActivity {

    //백그라운드

    private RelativeLayout marathonPlayActBackground;

    //스톱워치

    private TextView marathonPlayStopWatch;
    Handler handler;
    long mBaseTime;

    //gps 구현

    private ImageView marathonPlayActGPSone;
    private ImageView marathonPlayActGPSTwo;
    private ImageView marathonPlayActGPSThree;
    private ImageView marathonPlayActGPSFour;

    private ImageView marathonPlayActLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marathon_play_activity);

        marathonPlayActLogo = (ImageView) findViewById(R.id.shoesListActLogo);
        marathonPlayActBackground = (RelativeLayout) findViewById(R.id.marathonPlayActBackground);
        Glide.with(this).load(R.drawable.map).override(100,100).into(new ViewTarget<RelativeLayout, GlideDrawable>(marathonPlayActBackground) {


            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                RelativeLayout mView = this.view;
                mView.setBackgroundResource(R.drawable.map);
            }
        });
//        marathonPlayActBackground.setBackgroundResource(R.drawable.map);

        marathonPlayStopWatch = (TextView) findViewById(R.id.marathonPlayStopWatch);

        handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                marathonPlayStopWatch.setText(getEllapse());

                handler.sendEmptyMessage(0);
            }
        };

        for (int i = 0; i <10; i++){

            mBaseTime = SystemClock.elapsedRealtime();
            handler.sendEmptyMessage(0);

            if(isDestroyed()){
                break;
            }

        }

        //gps 구현

        marathonPlayActGPSone = (ImageView) findViewById(R.id.marathonPlayActGPSone);
        marathonPlayActGPSTwo = (ImageView) findViewById(R.id.marathonPlayActGPSTwo);
        marathonPlayActGPSThree = (ImageView) findViewById(R.id.marathonPlayActGPSThree);
        marathonPlayActGPSFour = (ImageView) findViewById(R.id.marathonPlayActGPSFour);

        TranslateAnimation anim = new TranslateAnimation(0,-500,0,-250);
        anim.setDuration(10000);
        anim.setRepeatCount(Animation.INFINITE);

        marathonPlayActGPSThree.startAnimation(anim);
        marathonPlayActLogo.bringToFront();


        TranslateAnimation anim2 = new TranslateAnimation(0,-150,0,500);
        anim2.setDuration(10000);
        anim2.setRepeatCount(Animation.INFINITE);
        marathonPlayActGPSFour.startAnimation(anim2);


//        TranslateAnimation anim3 = new TranslateAnimation(0,-1000,0,-650);
//        anim3.setDuration(2000);
//        marathonPlayActGPSone.startAnimation(anim3);

//        TranslateAnimation anim4 = new TranslateAnimation(0,-250,0,10);
//        anim4.setDuration(2000);
//        marathonPlayActGPSTwo.startAnimation(anim4);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.gps);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.gpsone);

        marathonPlayActGPSTwo.startAnimation(animation);


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim = AnimationUtils.loadAnimation(MarathonPlayActivity.this,R.anim.gps);
                anim.setAnimationListener(this);
                marathonPlayActGPSTwo.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        marathonPlayActGPSone.startAnimation(animation2);

        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim = AnimationUtils.loadAnimation(MarathonPlayActivity.this,R.anim.gpsone);
                anim.setAnimationListener(this);
                marathonPlayActGPSone.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }




    String getEllapse(){
        long now = SystemClock.elapsedRealtime();
        long ell = now - mBaseTime;
        String sEll = String.format("%02d:%02d:%02d", ell/1000/60, (ell/1000)%60, (ell%1000)/10);
        return sEll;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
        Glide.get(this).clearMemory();

    }
}
