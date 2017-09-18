package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private ImageView tom;
    private RelativeLayout menu;
    private ImageView trop;
    private ImageView tropTwo;
    private ImageView image;
    private ImageView imageTwo;
    private ImageView time;
    private ImageView timeTwo;
    private ImageView justin;
    private ImageView justinTwo;

    private boolean friendList = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tom = (ImageView) findViewById(R.id.tomphoto);
        menu = (RelativeLayout) findViewById(R.id.menu);
        trop = (ImageView) findViewById(R.id.trop);
        tropTwo = (ImageView) findViewById(R.id.troptwo);
        image = (ImageView) findViewById(R.id.image);
        imageTwo = (ImageView) findViewById(R.id.imagetwo);
        time = (ImageView) findViewById(R.id.time);
        timeTwo = (ImageView) findViewById(R.id.timetwo);
        justin = (ImageView) findViewById(R.id.justin);
//        justinTwo = (ImageView) findViewById(R.id.justintwo);

        tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(menu.getVisibility() != View.VISIBLE){
                    Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    menu.startAnimation(fadeIn);
                    menu.setVisibility(View.VISIBLE);
                } else {

                    menu.setVisibility(View.GONE);
                    trop.setVisibility(VISIBLE);
                    tropTwo.setVisibility(View.GONE);
                    image.setVisibility(VISIBLE);
                    imageTwo.setVisibility(View.GONE);
                    time.setVisibility(VISIBLE);
                    timeTwo.setVisibility(View.GONE);
                    Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                    menu.startAnimation(fadeOut);


                }
            }
        });

        trop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tropTwo.setVisibility(VISIBLE);
                trop.setVisibility(View.GONE);


                if(imageTwo.getVisibility() == VISIBLE){
                    imageTwo.setVisibility(View.GONE);
                    image.setVisibility(VISIBLE);
                }
                if(timeTwo.getVisibility() == VISIBLE){
                    timeTwo.setVisibility(View.GONE);
                    time.setVisibility(VISIBLE);
                }


                Intent intent = new Intent(MainActivity.this,MarathonActivity.class);
                startActivity(intent);
            }
        });

        tropTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,MarathonActivity.class);
                startActivity(intent);

            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageTwo.setVisibility(VISIBLE);
                image.setVisibility(View.GONE);

                if(tropTwo.getVisibility() == VISIBLE){
                    tropTwo.setVisibility(View.GONE);
                    trop.setVisibility(VISIBLE);
                }
                if(timeTwo.getVisibility() == VISIBLE){
                    timeTwo.setVisibility(View.GONE);
                    time.setVisibility(VISIBLE);
                }
                Intent intent = new Intent(MainActivity.this,ShoesActivity.class);
                startActivity(intent);
            }
        });
        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShoesActivity.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeTwo.setVisibility(VISIBLE);
                time.setVisibility(View.GONE);

                if(imageTwo.getVisibility() == VISIBLE){
                    imageTwo.setVisibility(View.GONE);
                    image.setVisibility(VISIBLE);
                }
                if(tropTwo.getVisibility() == VISIBLE){
                    tropTwo.setVisibility(View.GONE);
                    trop.setVisibility(VISIBLE);
                }
                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                startActivity(intent);
            }
        });

        justin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                justinTwo.setVisibility(VISIBLE);
//                justin.setVisibility(View.GONE);
//
//                if(justinTwo.getVisibility() == View.VISIBLE){
//                    justinTwo.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            justinTwo.setVisibility(View.GONE);
//                            justin.setVisibility(VISIBLE);
//                        }
//                    });
//                }
                if(friendList){

                    ViewGroup.LayoutParams justinParams = justin.getLayoutParams();
                    int justinWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,25,getResources().getDisplayMetrics());
                    int justinHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,getResources().getDisplayMetrics());
                    justinParams.width = justinWidth;
                    justinParams.height = justinHeight;
                    Glide.with(getApplicationContext()).load(R.drawable.asdf).into(justin);
                    friendList = false;

                } else {

                    ViewGroup.LayoutParams justinParams = justin.getLayoutParams();
                    int justinWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,180,getResources().getDisplayMetrics());
                    int justinHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,250,getResources().getDisplayMetrics());
                    justinParams.width = justinWidth;
                    justinParams.height = justinHeight;
                    Glide.with(getApplicationContext()).load(R.drawable.justin).override(1000,1000).into(justin);
                    friendList = true;
                }



            }

        });

        timeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Glide.get(this).clearMemory();
    }
}
