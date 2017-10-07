package com.example.heizepalvin.nikeplus;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pl.polidea.view.ZoomView;

/**
 * Created by soyounguensoo on 2017-08-28.
 */

public class TimeActivity extends AppCompatActivity{

    //화면 왼쪽에서 부터
    private ImageView timeActImgLed;
    private ImageView timeActImgTodayRunning;
    private ImageView timeActImgTodayRunningTwo;
    private ImageView timeActImgGoodDesign;
    private ImageView timeActImgMyFace;
    private ImageView timeActImgNiceRunning;
    private ImageView timeActFriendList;
    private ImageView timeActSideMenu;
    private FrameLayout timeActFrameLayout;

    //상단 메뉴

    private ImageView timeActMenu;
    private ImageView timeActLogo;
    private LinearLayout timeActMenuText;

    //상단 메뉴 텍스트

    private TextView timeActMenuHome;
    private TextView timeActMenuMarathon;
    private TextView timeActMenuMyCourse;
    private TextView timeActMenuGraph;
    private TextView timeActMenuMoisture;
    private TextView timeActMenuShoeRack;
    private TextView timeActMenuCustom;
    private TextView timeActMenuLED;

    //좋아요 버튼

    private ImageView timeActHeartFirst;
    private FrameLayout timeActHeart;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_activity_background);



        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.time_activity,null,false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


        //좋아요 버튼

        timeActHeartFirst = (ImageView) v.findViewById(R.id.timeActHeartFirst);
        timeActHeart = (FrameLayout) v.findViewById(R.id.timeActHeart);
        timeActHeart.setOnClickListener(onClickListener);
        //좋아요 끝


        timeActImgLed = (ImageView) v.findViewById(R.id.timeActBigLogo);

        Glide.with(this).load(R.drawable.led).override(300,300).into(timeActImgLed);

        timeActImgLed.setOnClickListener(onClickListener);
        Log.e("asdfasdf",timeActImgLed + "");
        timeActImgTodayRunning = (ImageView) v.findViewById(R.id.timeActRunning);

        Glide.with(this).load(R.drawable.running2).into(timeActImgTodayRunning);

        timeActImgTodayRunning.setOnClickListener(onClickListener);
        timeActImgTodayRunningTwo = (ImageView) v.findViewById(R.id.timeActRunningSecond);
        Glide.with(this).load(R.drawable.runningtwo2).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);
        timeActImgTodayRunningTwo.setOnClickListener(onClickListener);
        timeActImgGoodDesign = (ImageView) v.findViewById(R.id.timeActGoodDesign);
        Glide.with(this).load(R.drawable.gooddesign2).override(300,300).dontAnimate().into(timeActImgGoodDesign);
        timeActImgGoodDesign.setOnClickListener(onClickListener);
        timeActImgMyFace = (ImageView) v.findViewById(R.id.timeActMyFace);
        Glide.with(this).load(R.drawable.myface2).override(300,300).dontAnimate().into(timeActImgMyFace);
        timeActImgMyFace.setOnClickListener(onClickListener);
        timeActImgNiceRunning = (ImageView) v.findViewById(R.id.timeActNiceRunning);
        Glide.with(this).load(R.drawable.nicerunning2).override(300,300).dontAnimate().into(timeActImgNiceRunning);
        timeActImgNiceRunning.setOnClickListener(onClickListener);
        timeActFriendList = (ImageView) v.findViewById(R.id.timeActFriendList);
//        Glide.with(this).load(R.drawable.justin).dontAnimate().into(timeActFriendList);
        timeActFriendList.setOnClickListener(onClickListener);
        timeActSideMenu = (ImageView) v.findViewById(R.id.timeActSideMenu);
        Glide.with(this).load(R.drawable.asdf).override(25,50).dontAnimate().into(timeActSideMenu);
        timeActSideMenu.setOnClickListener(onClickListener);
        timeActFrameLayout = (FrameLayout) v.findViewById(R.id.timeActFrameLayout);

        //상단 메뉴

        timeActMenu = (ImageView) v.findViewById(R.id.timeActMenu);
        Glide.with(this).load(R.drawable.logomenu).override(200,200).dontAnimate().into(timeActMenu);
        timeActMenu.setOnClickListener(onClickListener);
        timeActLogo = (ImageView) v.findViewById(R.id.marathonPlayActLogo);
        Glide.with(this).load(R.drawable.logo).override(100,100).dontAnimate().into(timeActLogo);
        timeActLogo.setOnClickListener(onClickListener);
        timeActMenuText = (LinearLayout) v.findViewById(R.id.timeActMenuText);
        timeActMenuText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeActLogo.setVisibility(View.VISIBLE);
                timeActMenuText.setVisibility(View.GONE);
                timeActMenu.setVisibility(View.GONE);
            }
        });

        //상단 메뉴 텍스트
        timeActMenuHome = (TextView) v.findViewById(R.id.timeActMenuHome);
        timeActMenuMarathon = (TextView) v.findViewById(R.id.timeActMenuMarathon);
        timeActMenuMyCourse = (TextView) v.findViewById(R.id.timeActMenuMyCourse);
        timeActMenuGraph = (TextView) v.findViewById(R.id.timeActMenuGraph);
        timeActMenuMoisture = (TextView) v.findViewById(R.id.timeActMenuMoisture);
        timeActMenuShoeRack = (TextView) v.findViewById(R.id.timeActMenuShoerack);
        timeActMenuCustom = (TextView) v.findViewById(R.id.timeActMenuCustom);
        timeActMenuLED = (TextView) v.findViewById(R.id.timeActMenuLed);


        timeActMenuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuMarathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, MarathonActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuMyCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, MyCourseActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, ChartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuMoisture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, MoistureActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuShoeRack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, ShoesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, ShoesCustomActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeActMenuLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, LedActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ZoomView zoomView = new ZoomView(this);
        zoomView.addView(v);
        zoomView.setLayoutParams(layoutParams);
        zoomView.setMaxZoom(4f);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(zoomView);
    }


    //이미지뷰 클릭 이벤트
    private ImageView.OnClickListener onClickListener = new ImageView.OnClickListener(){

        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.timeActBigLogo:

//                    timeActImgLed.setImageResource(R.drawable.led);

                    Glide.with(getApplicationContext()).load(R.drawable.led).override(300,300).dontAnimate().into(timeActImgLed);
                    timeActImgLed.bringToFront();
                    timeActHeart.bringToFront();

//
//                    timeActImgTodayRunning.setImageResource(R.drawable.running2);
//                    timeActImgTodayRunningTwo.setImageResource(R.drawable.runningtwo2);
//                    timeActImgGoodDesign.setImageResource(R.drawable.gooddesign2);
//                    timeActImgMyFace.setImageResource(R.drawable.myface2);
//                    timeActImgNiceRunning.setImageResource(R.drawable.nicerunning2);

                    // 17/09/13 Glide 적용 수정
//
                    Glide.with(getApplicationContext()).load(R.drawable.running2).override(300,300).dontAnimate().into(timeActImgTodayRunning);
                    Glide.with(getApplicationContext()).load(R.drawable.runningtwo2).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);
                    Glide.with(getApplicationContext()).load(R.drawable.gooddesign2).override(300,300).dontAnimate().into(timeActImgGoodDesign);
                    Glide.with(getApplicationContext()).load(R.drawable.myface2).override(300,300).dontAnimate().into(timeActImgMyFace);
                    Glide.with(getApplicationContext()).load(R.drawable.nicerunning2).override(300,300).dontAnimate().into(timeActImgNiceRunning);

                    break;

                case R.id.timeActRunning:

//                    timeActImgTodayRunning.setImageResource(R.drawable.running);

                    Glide.with(getApplicationContext()).load(R.drawable.running).override(300,300).dontAnimate().into(timeActImgTodayRunning);
                    timeActImgTodayRunning.bringToFront();
                    timeActHeart.bringToFront();



                    //밑에 있는 것은 클릭시 화면 크기 변경할 때
//                    ViewGroup.LayoutParams todayRunningParams = timeActImgTodayRunning.getLayoutParams();
//                    int todayRunningWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,180,getResources().getDisplayMetrics());
//                    int todayRunningHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,190,getResources().getDisplayMetrics());
//                    todayRunningParams.width = todayRunningWidth;
//                    todayRunningParams.height = todayRunningHeight;
//
//                    timeActImgLed.setImageResource(R.drawable.led2);
//                    timeActImgTodayRunningTwo.setImageResource(R.drawable.runningtwo2);
//                    timeActImgGoodDesign.setImageResource(R.drawable.gooddesign2);
//                    timeActImgMyFace.setImageResource(R.drawable.myface2);
//                    timeActImgNiceRunning.setImageResource(R.drawable.nicerunning2);

                    // 17/09/13 Glide 적용 수정

                    Glide.with(getApplicationContext()).load(R.drawable.led2).override(300,300).dontAnimate().into(timeActImgLed);
                    Glide.with(getApplicationContext()).load(R.drawable.runningtwo2).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);
                    Glide.with(getApplicationContext()).load(R.drawable.gooddesign2).override(300,300).dontAnimate().into(timeActImgGoodDesign);
                    Glide.with(getApplicationContext()).load(R.drawable.myface2).override(300,300).dontAnimate().into(timeActImgMyFace);
                    Glide.with(getApplicationContext()).load(R.drawable.nicerunning2).override(300,300).dontAnimate().into(timeActImgNiceRunning);

                    break;

                case R.id.timeActRunningSecond:

//                    timeActImgTodayRunningTwo.setImageResource(R.drawable.runningtwo);

                    Glide.with(getApplicationContext()).load(R.drawable.runningtwo).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);

                    timeActImgTodayRunningTwo.bringToFront();
                    timeActHeart.bringToFront();



//                    timeActImgLed.setImageResource(R.drawable.led2);
//                    timeActImgTodayRunning.setImageResource(R.drawable.running2);
//                    timeActImgGoodDesign.setImageResource(R.drawable.gooddesign2);
//                    timeActImgMyFace.setImageResource(R.drawable.myface2);
//                    timeActImgNiceRunning.setImageResource(R.drawable.nicerunning2);

                    // 17/09/13 Glide 적용 수정

                    Glide.with(getApplicationContext()).load(R.drawable.led2).override(300,300).dontAnimate().into(timeActImgLed);
                    Glide.with(getApplicationContext()).load(R.drawable.running2).override(300,300).dontAnimate().into(timeActImgTodayRunning);
                    Glide.with(getApplicationContext()).load(R.drawable.gooddesign2).override(300,300).dontAnimate().into(timeActImgGoodDesign);
                    Glide.with(getApplicationContext()).load(R.drawable.myface2).override(300,300).dontAnimate().into(timeActImgMyFace);
                    Glide.with(getApplicationContext()).load(R.drawable.nicerunning2).override(300,300).dontAnimate().into(timeActImgNiceRunning);

                    break;
                case R.id.timeActGoodDesign:

//                    timeActImgGoodDesign.setImageResource(R.drawable.gooddesign);

                    Glide.with(getApplicationContext()).load(R.drawable.gooddesign).override(300,300).dontAnimate().into(timeActImgGoodDesign);

                    timeActImgGoodDesign.bringToFront();
                    timeActHeart.bringToFront();


//                    timeActImgLed.setImageResource(R.drawable.led2);
//                    timeActImgTodayRunningTwo.setImageResource(R.drawable.runningtwo2);
//                    timeActImgTodayRunning.setImageResource(R.drawable.running2);
//                    timeActImgMyFace.setImageResource(R.drawable.myface2);
//                    timeActImgNiceRunning.setImageResource(R.drawable.nicerunning2);

                    // 17/09/13 Glide 적용 수정

                    Glide.with(getApplicationContext()).load(R.drawable.led2).override(300,300).dontAnimate().into(timeActImgLed);
                    Glide.with(getApplicationContext()).load(R.drawable.runningtwo2).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);
                    Glide.with(getApplicationContext()).load(R.drawable.running2).override(300,300).dontAnimate().into(timeActImgTodayRunning);
                    Glide.with(getApplicationContext()).load(R.drawable.myface2).override(300,300).dontAnimate().into(timeActImgMyFace);
                    Glide.with(getApplicationContext()).load(R.drawable.nicerunning2).override(300,300).dontAnimate().into(timeActImgNiceRunning);

                    break;

                case R.id.timeActMyFace:

//                    timeActImgMyFace.setImageResource(R.drawable.myface);

                    Glide.with(getApplicationContext()).load(R.drawable.myface).override(300,300).dontAnimate().into(timeActImgMyFace);
                    timeActImgMyFace.bringToFront();
                    timeActHeart.bringToFront();


//                    timeActImgLed.setImageResource(R.drawable.led2);
//                    timeActImgTodayRunningTwo.setImageResource(R.drawable.runningtwo2);
//                    timeActImgTodayRunning.setImageResource(R.drawable.running2);
//                    timeActImgGoodDesign.setImageResource(R.drawable.gooddesign2);
//                    timeActImgNiceRunning.setImageResource(R.drawable.nicerunning2);

                    // 17/09/13 Glide 적용 수정

                    Glide.with(getApplicationContext()).load(R.drawable.led2).override(300,300).dontAnimate().into(timeActImgLed);
                    Glide.with(getApplicationContext()).load(R.drawable.runningtwo2).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);
                    Glide.with(getApplicationContext()).load(R.drawable.running2).override(300,300).dontAnimate().into(timeActImgTodayRunning);
                    Glide.with(getApplicationContext()).load(R.drawable.gooddesign2).override(300,300).dontAnimate().into(timeActImgGoodDesign);
                    Glide.with(getApplicationContext()).load(R.drawable.nicerunning2).override(300,300).dontAnimate().into(timeActImgNiceRunning);

                    break;

                case R.id.timeActNiceRunning:

//                    timeActImgNiceRunning.setImageResource(R.drawable.nicerunning);

                    Glide.with(getApplicationContext()).load(R.drawable.nicerunning).override(300,300).dontAnimate().into(timeActImgNiceRunning);
                    timeActFrameLayout.bringToFront();
                    timeActHeart.bringToFront();

//                    timeActImgLed.setImageResource(R.drawable.led2);
//                    timeActImgTodayRunningTwo.setImageResource(R.drawable.runningtwo2);
//                    timeActImgTodayRunning.setImageResource(R.drawable.running2);
//                    timeActImgMyFace.setImageResource(R.drawable.myface2);
//                    timeActImgGoodDesign.setImageResource(R.drawable.gooddesign2);

                    // 17/09/13 Glide 적용 수정

                    Glide.with(getApplicationContext()).load(R.drawable.led2).override(300,300).dontAnimate().into(timeActImgLed);
                    Glide.with(getApplicationContext()).load(R.drawable.runningtwo2).override(300,300).dontAnimate().into(timeActImgTodayRunningTwo);
                    Glide.with(getApplicationContext()).load(R.drawable.running2).override(300,300).dontAnimate().into(timeActImgTodayRunning);
                    Glide.with(getApplicationContext()).load(R.drawable.gooddesign2).override(300,300).dontAnimate().into(timeActImgGoodDesign);
                    Glide.with(getApplicationContext()).load(R.drawable.myface2).override(300,300).dontAnimate().into(timeActImgMyFace);


                    break;
                case R.id.timeActFriendList:

                    timeActSideMenu.setVisibility(View.VISIBLE);
                    timeActFriendList.setVisibility(View.GONE);
                    timeActHeart.bringToFront();

                    break;
                case R.id.timeActSideMenu:

                    timeActSideMenu.setVisibility(View.GONE);
                    timeActFriendList.setVisibility(View.VISIBLE);

                    break;

                //상단 메뉴

                case R.id.marathonPlayActLogo:

                    timeActLogo.setVisibility(View.GONE);
                    timeActMenu.setVisibility(View.VISIBLE);
                    timeActMenuText.setVisibility(View.VISIBLE);
                    timeActMenu.bringToFront();
                    timeActMenuText.bringToFront();

                    break;
                case R.id.timeActMenu:

                    timeActLogo.setVisibility(View.VISIBLE);
                    timeActMenuText.setVisibility(View.GONE);
                    timeActMenu.setVisibility(View.GONE);

                    break;

                case R.id.timeActHeart:

                    if(timeActHeartFirst.getVisibility() == View.VISIBLE){
                        timeActHeartFirst.setVisibility(View.GONE);
                    } else {
                        timeActHeartFirst.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        }
    };

    private void recycleImage(ImageView iv){
        Drawable recycle = iv.getDrawable();
        Bitmap recycleBmp = ((BitmapDrawable)recycle).getBitmap();
        recycleBmp.recycle();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();



    }

}
