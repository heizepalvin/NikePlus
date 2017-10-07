package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    //메뉴
    private ImageView marathonPlayActLogo;
    private ImageView marathonPlayActMenu;
    private LinearLayout marathonPlayActMenuText;
    private TextView marathonPlayActMenuHome;
    private TextView marathonPlayActMenuTimeline;
    private TextView marathonPlayActMenuGraph;
    private TextView marathonPlayActMenuMyCourse;
    private TextView marathonPlayActMenuMoisture;
    private TextView marathonPlayActMenuShoeRack;
    private TextView marathonPlayActMenuCustom;
    private TextView marathonPlayActMenuLED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marathon_play_activity);

        //menu
        marathonPlayActLogo = (ImageView) findViewById(R.id.marathonPlayActLogo);
        marathonPlayActMenu = (ImageView) findViewById(R.id.marathonPlayActMenu);
        marathonPlayActMenuText = (LinearLayout) findViewById(R.id.marathonPlayMenuText);

        marathonPlayActLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marathonPlayActLogo.setVisibility(View.GONE);
                marathonPlayActMenu.setVisibility(View.VISIBLE);
                marathonPlayActMenuText.setVisibility(View.VISIBLE);
                marathonPlayActMenuText.bringToFront();
            }
        });

        marathonPlayActMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marathonPlayActLogo.setVisibility(View.VISIBLE);
                marathonPlayActMenu.setVisibility(View.GONE);
                marathonPlayActMenuText.setVisibility(View.GONE);
            }
        });

        marathonPlayActMenuHome = (TextView) findViewById(R.id.marathonPlayactMenuHome);
        marathonPlayActMenuHome.setOnClickListener(onClickListener);
        marathonPlayActMenuTimeline = (TextView) findViewById(R.id.marathonPlayActMenuTimeline);
        marathonPlayActMenuGraph = (TextView) findViewById(R.id.marathonPlayActMenuGraph);
        marathonPlayActMenuGraph.setOnClickListener(onClickListener);
        marathonPlayActMenuMyCourse = (TextView) findViewById(R.id.marathonPlayActMenuMyCourse);
        marathonPlayActMenuMyCourse.setOnClickListener(onClickListener);
        marathonPlayActMenuMoisture = (TextView) findViewById(R.id.marathonPlayActMenuMoisture);
        marathonPlayActMenuMoisture.setOnClickListener(onClickListener);
        marathonPlayActMenuShoeRack = (TextView) findViewById(R.id.marathonPlayActMenuShoerack);
        marathonPlayActMenuShoeRack.setOnClickListener(onClickListener);
        marathonPlayActMenuCustom = (TextView) findViewById(R.id.marathonPlayActMenuCustom);
        marathonPlayActMenuCustom.setOnClickListener(onClickListener);
        marathonPlayActMenuLED = (TextView) findViewById(R.id.marathonPlayActMenuLed);
        marathonPlayActMenuLED.setOnClickListener(onClickListener);

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

    private TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.marathonPlayactMenuHome:

                    Intent intent = new Intent(MarathonPlayActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                    break;
                case R.id.marathonPlayActMenuTimeline:

                    Intent intent2 = new Intent(MarathonPlayActivity.this, TimeActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    finish();

                    break;
                case R.id.marathonPlayActMenuGraph:

                    Intent intent3 = new Intent(MarathonPlayActivity.this, ChartActivity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    finish();

                    break;
                case R.id.marathonPlayActMenuMyCourse:

                    Intent intent4 = new Intent(MarathonPlayActivity.this, MyCourseActivity.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent4);
                    finish();

                    break;
                case R.id.marathonPlayActMenuMoisture:

                    Intent intent5 = new Intent(MarathonPlayActivity.this, MoistureActivity.class);
                    intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent5);
                    finish();

                    break;
                case R.id.marathonPlayActMenuShoerack:

                    Intent intent6 = new Intent(MarathonPlayActivity.this, ShoesActivity.class);
                    intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent6);
                    finish();

                    break;
                case R.id.marathonPlayActMenuCustom:

                    Intent intent7 = new Intent(MarathonPlayActivity.this, ShoesCustomActivity.class);
                    intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent7);
                    finish();

                    break;
                case R.id.marathonPlayActMenuLed:

                    Intent intent8 = new Intent(MarathonPlayActivity.this, LedActivity.class);
                    intent8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent8);
                    finish();

                    break;
            }
        }
    };




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
