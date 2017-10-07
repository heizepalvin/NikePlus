package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by soyounguensoo on 2017-09-05.
 */

public class MarathonActivity extends AppCompatActivity {

    //코스 체인지 버튼

    private ImageView changeLeftBtn;
    private ImageView changeRightBtn;
    private ImageView changeCourse;

    private int courseNumber = 2;

    //상단 메뉴

    private ImageView marathonActLogo;
    private ImageView marathonActMenu;
    private LinearLayout marathonActMenuText;

    //상단 메뉴 텍스트

    private TextView marathonActMenuHome;
    private TextView marathonActMenuTimeline;
    private TextView marathonActMenuGraph;
    private TextView marathonActMenuMycourse;
    private TextView marathonActMenuMoisture;
    private TextView marathonActMenuShoeRack;
    private TextView marathonActMenuCustom;
    private TextView marathonActMenuLED;

    //코스마다 사람 이미지, gps위치, 반경을 나타내는 원

    private ImageView marathonActFriendOne;
    private ImageView marathonActFriendTwo;
    private ImageView marathonActFriendThree;
    private ImageView marathonActGPSone;
    private ImageView marathonActGPStwo;
    private ImageView marathonActGPSthree;
    private ImageView marathonActRadius;
    private ImageView marathonActRadiusTwo;
    private ImageView marathonActRadiusThree;

    private RelativeLayout marathonActBackground;

    private ImageView marathonActCourseTomHardy;
    private ImageView marathonActCourseBackground;
    private ImageView marathonActCircle;

    //마라톤 플레이 액티비티 버튼

    private ImageView marathonActCourseBtn;


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        recycleView(findViewById(R.id.marathonActBackground));
//    }
//
//    private void recycleView (View view){
//        if(view != null){
//            Drawable bg = view.getBackground();
//            if(bg!=null){
//                bg.setCallback(null);
//                ((BitmapDrawable)bg).getBitmap().recycle();
//                view.setBackgroundDrawable(null);
//            }
//        }
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marathon_activity);

        marathonActBackground = (RelativeLayout) findViewById(R.id.marathonActBackground);
        marathonActBackground.setBackgroundResource(R.drawable.marathonbg);

        marathonActGPSone = (ImageView) findViewById(R.id.marathonActGPSone);
        marathonActGPStwo = (ImageView) findViewById(R.id.marathonActGPStwo);
        marathonActGPSthree = (ImageView) findViewById(R.id.marathonActGPSthree);
        marathonActRadius = (ImageView) findViewById(R.id.marathonActRadius);
        marathonActRadiusTwo = (ImageView) findViewById(R.id.marathonActRadius2);
        marathonActRadiusThree = (ImageView) findViewById(R.id.marathonActRadius3);

        marathonActCourseBackground = (ImageView) findViewById(R.id.marathonActCourseBackground);
//        marathonActCourseTomHardy = (ImageView) findViewById(R.id.marathonActCourseTomHardy);
        Glide.with(this).load(R.drawable.marathonbox).into(marathonActCourseBackground);
//        Glide.with(this).load(R.drawable.marathonprofile).into(marathonActCourseTomHardy);

//        marathonActCircle = (ImageView) findViewById(R.id.marathonActCircle);
//        Glide.with(this).load(R.drawable.radius).into(marathonActCircle);

        changeLeftBtn = (ImageView) findViewById(R.id.marathonActLeft);
        changeRightBtn = (ImageView) findViewById(R.id.marathonActRight);
        changeCourse = (ImageView) findViewById(R.id.marathonActChange);
        Glide.with(this).load(R.drawable.cantral).into(changeCourse);

        marathonActFriendOne = (ImageView) findViewById(R.id.marathonActFriendOne);
        marathonActFriendTwo = (ImageView) findViewById(R.id.marathonActFriendTwo);
        marathonActFriendThree = (ImageView) findViewById(R.id.marathonActFriendThree);

        //마라톤 플레이 액티비티로 넘어가기

        marathonActCourseBtn = (ImageView) findViewById(R.id.marathonActCourseBtn);
        marathonActCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarathonActivity.this, MarathonPlayActivity.class);
                startActivity(intent);
                finish();
            }
        });

        changeLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(courseNumber==2){
                    courseNumber = 1;
                    Glide.with(MarathonActivity.this).load(R.drawable.brodway).into(changeCourse);

                    marathonActFriendTwo.setVisibility(View.VISIBLE);
                    marathonActFriendOne.setVisibility(View.GONE);
                    marathonActFriendThree.setVisibility(View.GONE);
                    marathonActRadiusTwo.setVisibility(View.VISIBLE);
                    marathonActRadius.setVisibility(View.INVISIBLE);
                    marathonActRadiusThree.setVisibility(View.INVISIBLE);
                    marathonActGPStwo.setVisibility(View.VISIBLE);
                    marathonActGPSone.setVisibility(View.INVISIBLE);
                    marathonActGPSthree.setVisibility(View.INVISIBLE);

                } else if(courseNumber == 1){
                    courseNumber = 3;
                    Glide.with(MarathonActivity.this).load(R.drawable.empire).into(changeCourse);


                    marathonActFriendThree.setVisibility(View.VISIBLE);
                    marathonActFriendOne.setVisibility(View.GONE);
                    marathonActFriendTwo.setVisibility(View.GONE);
                    marathonActRadiusThree.setVisibility(View.VISIBLE);
                    marathonActRadius.setVisibility(View.INVISIBLE);
                    marathonActRadiusTwo.setVisibility(View.INVISIBLE);
                    marathonActGPSthree.setVisibility(View.VISIBLE);
                    marathonActGPStwo.setVisibility(View.INVISIBLE);
                    marathonActGPSone.setVisibility(View.INVISIBLE);


                } else if(courseNumber == 3){
                    courseNumber = 2;
                    Glide.with(MarathonActivity.this).load(R.drawable.cantral).into(changeCourse);
                    marathonActFriendOne.setVisibility(View.VISIBLE);
                    marathonActFriendTwo.setVisibility(View.GONE);
                    marathonActFriendThree.setVisibility(View.GONE);
                    marathonActRadius.setVisibility(View.VISIBLE);
                    marathonActRadiusThree.setVisibility(View.INVISIBLE);
                    marathonActRadiusTwo.setVisibility(View.INVISIBLE);
                    marathonActGPSone.setVisibility(View.VISIBLE);
                    marathonActGPSthree.setVisibility(View.INVISIBLE);
                    marathonActGPStwo.setVisibility(View.INVISIBLE);
                }
            }
        });

        changeRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(courseNumber == 1){
                    courseNumber = 2;
//                    changeCourse.setImageResource(R.drawable.cantral);
                    Glide.with(MarathonActivity.this).load(R.drawable.cantral).into(changeCourse);
                    marathonActFriendOne.setVisibility(View.VISIBLE);
                    marathonActFriendTwo.setVisibility(View.GONE);
                    marathonActFriendThree.setVisibility(View.GONE);
                    marathonActRadius.setVisibility(View.VISIBLE);
                    marathonActRadiusThree.setVisibility(View.INVISIBLE);
                    marathonActRadiusTwo.setVisibility(View.INVISIBLE);
                    marathonActGPSone.setVisibility(View.VISIBLE);
                    marathonActGPSthree.setVisibility(View.INVISIBLE);
                    marathonActGPStwo.setVisibility(View.INVISIBLE);

                } else if(courseNumber == 2){
                    courseNumber = 3;
//                    changeCourse.setImageResource(R.drawable.empire);
                    Glide.with(MarathonActivity.this).load(R.drawable.empire).into(changeCourse);
                    marathonActFriendThree.setVisibility(View.VISIBLE);
                    marathonActFriendOne.setVisibility(View.GONE);
                    marathonActFriendTwo.setVisibility(View.GONE);
                    marathonActRadiusThree.setVisibility(View.VISIBLE);
                    marathonActRadius.setVisibility(View.INVISIBLE);
                    marathonActRadiusTwo.setVisibility(View.INVISIBLE);
                    marathonActGPSthree.setVisibility(View.VISIBLE);
                    marathonActGPStwo.setVisibility(View.INVISIBLE);
                    marathonActGPSone.setVisibility(View.INVISIBLE);

                } else if(courseNumber == 3){
                    courseNumber = 1;
//                    changeCourse.setImageResource(R.drawable.brodway);
                    Glide.with(MarathonActivity.this).load(R.drawable.brodway).into(changeCourse);
                    marathonActFriendTwo.setVisibility(View.VISIBLE);
                    marathonActFriendOne.setVisibility(View.GONE);
                    marathonActFriendThree.setVisibility(View.GONE);
                    marathonActRadiusTwo.setVisibility(View.VISIBLE);
                    marathonActRadius.setVisibility(View.INVISIBLE);
                    marathonActRadiusThree.setVisibility(View.INVISIBLE);
                    marathonActGPStwo.setVisibility(View.VISIBLE);
                    marathonActGPSone.setVisibility(View.INVISIBLE);
                    marathonActGPSthree.setVisibility(View.INVISIBLE);
                }

            }
        });


        //상단 메뉴

        marathonActLogo = (ImageView) findViewById(R.id.marathonPlayActLogo);
        marathonActMenu = (ImageView) findViewById(R.id.marathonActMenu);
        marathonActMenuText = (LinearLayout) findViewById(R.id.marathonActMenuText);

        marathonActLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marathonActLogo.setVisibility(View.GONE);
                marathonActMenu.setVisibility(View.VISIBLE);
                marathonActMenuText.setVisibility(View.VISIBLE);

            }
        });

        marathonActMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marathonActLogo.setVisibility(View.VISIBLE);
                marathonActMenu.setVisibility(View.GONE);
                marathonActMenuText.setVisibility(View.GONE);


            }
        });

        //상단 메뉴 텍스트 이벤트

        marathonActMenuHome = (TextView) findViewById(R.id.marathonActMenuHome);
        marathonActMenuTimeline = (TextView) findViewById(R.id.marathonActMenuTimeline);
        marathonActMenuGraph = (TextView) findViewById(R.id.marathonActMenuGraph);
        marathonActMenuMycourse = (TextView) findViewById(R.id.marathonActMenuMycourse);
        marathonActMenuMoisture = (TextView) findViewById(R.id.marathonActMenuMoisture);
        marathonActMenuShoeRack = (TextView) findViewById(R.id.marathonActMenuShoerack);
        marathonActMenuCustom = (TextView) findViewById(R.id.marathonActMenuCustom);
        marathonActMenuLED = (TextView) findViewById(R.id.marathonActMenuLed);

        marathonActMenuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        marathonActMenuTimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,TimeActivity.class);
                startActivity(intent);
                finish();

            }
        });

        marathonActMenuGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,TimeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        marathonActMenuMycourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,MyCourseActivity.class);
                startActivity(intent);
                finish();
            }
        });

        marathonActMenuMoisture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,MoistureActivity.class);
                startActivity(intent);
                finish();
            }
        });

        marathonActMenuShoeRack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,ShoesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        marathonActMenuCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,ShoesCustomActivity.class);
                startActivity(intent);
                finish();
            }
        });

        marathonActMenuLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarathonActivity.this,LedActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Glide.get(this).clearMemory();
    }
}
