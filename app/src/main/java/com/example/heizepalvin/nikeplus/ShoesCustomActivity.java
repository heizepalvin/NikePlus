package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by soyounguensoo on 2017-10-04.
 */

public class ShoesCustomActivity extends AppCompatActivity {

    private ImageView shoesCustomActFront;
    private ImageView shoesCustomActBack;
    private ImageView shoesCustomActRedBtn;
    private ImageView shoesCustomActBlueBtn;
    private ImageView shoesCustomActGreenBtn;
    private ImageView shoesCustomActPurpleBtn;
    private ImageView shoesCustomActSaveBtn;
    private ImageView shoesCustomActDeleteBtn;
    private ImageView shoesCustomActFinishBtn;

    private ImageView shoesCustomActLogo;
    private ImageView shoesCustomActMenu;
    private LinearLayout shoesCustomActMenuLinear;
    private TextView shoesCustomActMenuHome;
    private TextView shoesCustomActTimeline;
    private TextView shoesCustomActCourse;
    private TextView shoesCustomActMarathon;
    private TextView shoesCustomActShoeRack;
    private TextView shoesCustomActGraph;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoes_custom_activity);

        shoesCustomActRedBtn = (ImageView) findViewById(R.id.shoesCustomActRed);
        shoesCustomActRedBtn.setOnClickListener(onClickListener);
        shoesCustomActBlueBtn = (ImageView) findViewById(R.id.shoesCustomActBlue);
        shoesCustomActBlueBtn.setOnClickListener(onClickListener);
        shoesCustomActGreenBtn = (ImageView) findViewById(R.id.shoesCustomActGreen);
        shoesCustomActGreenBtn.setOnClickListener(onClickListener);
        shoesCustomActPurpleBtn = (ImageView) findViewById(R.id.shoesCustomActPurple);
        shoesCustomActPurpleBtn.setOnClickListener(onClickListener);

        shoesCustomActFront = (ImageView) findViewById(R.id.shoesCustomActfront);
        shoesCustomActFront.setOnClickListener(onClickListener);
        shoesCustomActBack = (ImageView) findViewById(R.id.shoesCustomActBack);
        shoesCustomActBack.setOnClickListener(onClickListener);

        shoesCustomActFinishBtn = (ImageView) findViewById(R.id.shoesCustomActFinish);
        shoesCustomActFinishBtn.setOnClickListener(onClickListener);
        shoesCustomActSaveBtn = (ImageView) findViewById(R.id.shoesCustomActSaveBtn);
        shoesCustomActSaveBtn.setOnClickListener(onClickListener);
        shoesCustomActDeleteBtn = (ImageView) findViewById(R.id.shoesCustomActDelete);
        shoesCustomActDeleteBtn.setOnClickListener(onClickListener);

        //메뉴

        shoesCustomActLogo = (ImageView) findViewById(R.id.shoesCustomActLogo);
        shoesCustomActLogo.setOnClickListener(onClickListener);
        shoesCustomActMenu = (ImageView) findViewById(R.id.shoesCustomActMenu);
        shoesCustomActMenu.setOnClickListener(onClickListener);
        shoesCustomActMenuLinear = (LinearLayout) findViewById(R.id.shoesCustomActMenuText);
        shoesCustomActMenuHome = (TextView) findViewById(R.id.shoesCustomActMenuHome);
        shoesCustomActMenuHome.setOnClickListener(textClickListener);
        shoesCustomActTimeline = (TextView) findViewById(R.id.shoesCustomActMenuTimeline);
        shoesCustomActTimeline.setOnClickListener(textClickListener);
        shoesCustomActCourse = (TextView) findViewById(R.id.shoesCustomActMenuCourse);
        shoesCustomActCourse.setOnClickListener(textClickListener);
        shoesCustomActMarathon = (TextView) findViewById(R.id.shoesCustomActMenuMarathon);
        shoesCustomActCourse.setOnClickListener(textClickListener);
        shoesCustomActShoeRack = (TextView) findViewById(R.id.shoesCustomActMenuShoerack);
        shoesCustomActShoeRack.setOnClickListener(textClickListener);
        shoesCustomActGraph = (TextView) findViewById(R.id.shoesCustomActMenuGraph);
        shoesCustomActGraph.setOnClickListener(textClickListener);

    }

    private TextView.OnClickListener textClickListener = new TextView.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.shoesCustomActMenuHome:

                    Intent intent = new Intent(ShoesCustomActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.shoesCustomActMenuTimeline:
                    Intent intent2 = new Intent(ShoesCustomActivity.this,TimeActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    finish();
                    break;
                case R.id.shoesCustomActMenuCourse:
                    Intent intent3 = new Intent(ShoesCustomActivity.this,MyCourseActivity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    finish();
                    break;
                case R.id.shoesCustomActMenuMarathon:
                    Intent intent4 = new Intent(ShoesCustomActivity.this,MarathonActivity.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent4);
                    finish();
                    break;
                case R.id.shoesCustomActMenuShoerack:
                    Intent intent5 = new Intent(ShoesCustomActivity.this,ShoesActivity.class);
                    intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent5);
                    finish();
                    break;
                case R.id.shoesCustomActMenuGraph:
                    Intent intent6 = new Intent(ShoesCustomActivity.this,ChartActivity.class);
                    intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent6);
                    finish();
            }
        }
    };

    private ImageView.OnClickListener onClickListener = new ImageView.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.shoesCustomActLogo:

                    shoesCustomActLogo.setVisibility(View.GONE);
                    shoesCustomActMenu.setVisibility(View.VISIBLE);
                    shoesCustomActMenuLinear.setVisibility(View.VISIBLE);
                    shoesCustomActMenu.bringToFront();
                    shoesCustomActMenuLinear.bringToFront();

                    break;

                case R.id.shoesCustomActMenu:

                    shoesCustomActMenu.setVisibility(View.GONE);
                    shoesCustomActMenuLinear.setVisibility(View.GONE);
                    shoesCustomActLogo.setVisibility(View.VISIBLE);

                    break;

                case R.id.shoesCustomActRed:

                    shoesCustomActFront.setVisibility(View.VISIBLE);
                    shoesCustomActBack.setVisibility(View.VISIBLE);
                    shoesCustomActFront.setImageResource(R.drawable.redfour);
                    shoesCustomActBack.setImageResource(R.drawable.redfive);

                    break;
                case R.id.shoesCustomActBlue:

                    shoesCustomActFront.setVisibility(View.VISIBLE);
                    shoesCustomActBack.setVisibility(View.VISIBLE);
                    shoesCustomActFront.setImageResource(R.drawable.bluefour);
                    shoesCustomActBack.setImageResource(R.drawable.bluefive);

                    break;
                case R.id.shoesCustomActGreen:

                    shoesCustomActFront.setVisibility(View.VISIBLE);
                    shoesCustomActBack.setVisibility(View.VISIBLE);
                    shoesCustomActFront.setImageResource(R.drawable.greenfour);
                    shoesCustomActBack.setImageResource(R.drawable.greenfive);

                    break;
                case R.id.shoesCustomActPurple:

                    shoesCustomActFront.setVisibility(View.VISIBLE);
                    shoesCustomActBack.setVisibility(View.VISIBLE);
                    shoesCustomActFront.setImageResource(R.drawable.purplethree);
                    shoesCustomActBack.setImageResource(R.drawable.purplefive);

                    break;

                case R.id.shoesCustomActfront:

                    shoesCustomActFront.setVisibility(View.INVISIBLE);

                    break;

                case R.id.shoesCustomActBack:

                    shoesCustomActBack.setVisibility(View.INVISIBLE);

                    break;

                case R.id.shoesCustomActFinish:

                    //전페이지로 넘어가기

                    finish();

                    break;

                case R.id.shoesCustomActSaveBtn:

                    //다음페이지 넘어가기

                    Intent intent = new Intent(ShoesCustomActivity.this,LedActivity.class);
                    startActivity(intent);
                    finish();

                    break;

                case R.id.shoesCustomActDelete:

                    // 신발 초기화
                    shoesCustomActFront.setImageResource(R.drawable.redthree);
                    shoesCustomActFront.setVisibility(View.INVISIBLE);
                    shoesCustomActBack.setImageResource(R.drawable.redfive);
                    shoesCustomActBack.setVisibility(View.INVISIBLE);

                    break;
            }
        }
    };


}
